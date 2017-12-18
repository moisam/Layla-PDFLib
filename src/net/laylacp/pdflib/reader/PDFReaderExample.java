/*
 *    Programmed By: Mohammed Isam [mohammed_isam1984@yahoo.com]
 *    Copyright 2017 (c)
 *
 *    file: PDFReaderExample.java
 *    This file is part of Layla-PDFLib.
 *
 *    Layla-PDFLib is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU Lesser General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    Layla-PDFLib is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU Lesser General Public License for more details.
 *
 *    You should have received a copy of the GNU Lesser General Public License
 *    along with Layla-PDFLib.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.laylacp.pdflib.reader;

import net.laylacp.pdflib.core.PDFDocument;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;

public class PDFReaderExample {

    JFrame jFrame = new JFrame("Layla PDF Library Demo");
    JPanel readingArea = new JPanel();
    JScrollPane scrollPane = new JScrollPane(readingArea);
    JButton next = new JButton(">");
    JButton prev = new JButton("<");
    JButton last = new JButton(">>");
    JButton first = new JButton("<<");
    JTextField curPage = new JTextField();
    JLabel totalPages = new JLabel();
    JLabel picLabel = new JLabel();
    JLabel zoomLabel = new JLabel("Zooming: ");
    JComboBox<String> zoomCombo = new JComboBox<>();

    PDFDocument pdfDocument;
    int pageNumber = 0;
    int[] zoomings;
    int selectedZooming = 0;

    public PDFReaderExample() {
        /*
         * add action listeners to the navigation buttons.
         */
        prev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(pageNumber <= 0) return;
                loadPage(--pageNumber);
                toggleButtons();
            }
        });

        first.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(pageNumber <= 0) return;
                pageNumber = 0;
                loadPage(pageNumber);
                toggleButtons();
            }
        });

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(pageNumber >= pdfDocument.getPageCount()) return;
                loadPage(++pageNumber);
                toggleButtons();
            }
        });

        last.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int count = pdfDocument.getPageCount();
                if(pageNumber >= count) return;
                pageNumber = count-1;
                loadPage(pageNumber);
                toggleButtons();
            }
        });

        zoomCombo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    int newZooming = zoomCombo.getSelectedIndex();
                    if(newZooming >= 0 && selectedZooming != newZooming) {
                        selectedZooming = newZooming;
                        loadPage(pageNumber);
                    }
                }

            }
        });
    }

    private void toggleButtons() {
        int count = pdfDocument.getPageCount();
        if(pageNumber <= 0) {
            prev.setEnabled(false);
            first.setEnabled(false);
            if(count > 0) {
                next.setEnabled(true);
                last.setEnabled(true);
            } else {
                next.setEnabled(false);
                last.setEnabled(false);
            }
        } else {
            prev.setEnabled(true);
            first.setEnabled(true);
            if(pageNumber < count-1) {
                next.setEnabled(true);
                last.setEnabled(true);
            } else {
                next.setEnabled(false);
                last.setEnabled(false);
            }
        }
        curPage.setText(String.valueOf(pageNumber+1));
    }

    public void createGUI() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        Dimension curPageSize = new Dimension(60, 30);
        curPage.setMinimumSize(curPageSize);
        curPage.setPreferredSize(curPageSize);
        curPage.setMaximumSize(curPageSize);
        curPage.setSize(curPageSize);

        JPanel strip = new JPanel();
        strip.add(first);
        strip.add(prev);
        strip.add(curPage);
        strip.add(totalPages);
        strip.add(next);
        strip.add(last);
        strip.add(zoomLabel);

        // add the supported zoomings
        String zoom[] = PDFDocument.getViewingOptionsNames();
        zoomings = PDFDocument.getViewingOptions();
        int count = zoom.length;
        for(int i = 0; i < count; i++) {
            zoomCombo.addItem(zoom[i]);
        }
        zoomCombo.setSelectedIndex(selectedZooming);
        strip.add(zoomCombo);

        first.setEnabled(false);
        prev.setEnabled(false);
        next.setEnabled(false);
        last.setEnabled(false);

        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        readingArea.add(picLabel);

        jFrame.add(strip, BorderLayout.NORTH);
        jFrame.add(scrollPane);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setSize(screenSize.width, screenSize.height);
    }

    public static void main(String[] args) {
        PDFReaderExample prog = new PDFReaderExample();
        // prepare the GUI
        prog.createGUI();
        PDFReader pdfReader = new PDFReader();
        // parse the PDF document
        prog.pdfDocument = pdfReader.parse("path/to/file.pdf");
        if(prog.pdfDocument == null) {
            prog.jFrame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            prog.showError("Failed to open PDF. Error: " + pdfReader.getLastError());
            return;
        }
        // get the page count
        int pageCount = prog.pdfDocument.getPageCount();
        if(pageCount > 0) {
            if(pageCount > 1) {
                prog.next.setEnabled(true);
                prog.last.setEnabled(true);
            }
            prog.curPage.setText("1");
            prog.totalPages.setText(" of " + pageCount);
            //prog.loadPage(0);
            prog.pageNumber = 0;
            prog.zoomCombo.setSelectedIndex(PDFDocument.FIT_WIDTH);
        } else {
            prog.showError("Failed to get PDF page count.");
        }
    }

    public void showError(String errMsg) {
        System.out.println(errMsg);
        JOptionPane.showMessageDialog(null, errMsg);
    }

    public void loadPage(int pageNumber) {
        jFrame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                int w = scrollPane.getWidth();
                int h = scrollPane.getHeight();

                // load the selected page as an image
                BufferedImage page = pdfDocument.getPage(pageNumber, w, h, zoomings[selectedZooming]);
                if(page != null) {
                    ImageIcon imageIcon = new ImageIcon(page);
                    picLabel.setIcon(imageIcon);
                    // restore the default cursor
                    PDFReaderExample.this.pageNumber = pageNumber;
                }
                jFrame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });
    }
}
