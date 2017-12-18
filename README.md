# Layla-PDFLib
An easy to use Java PDF rendering library
# Why another PDF library
Because PDF is everywhere, and we often need to show PDF files (or parts of) in our programs. Whether you are writing a Java program for the desktop, Android, or any other platform, you will reach the point where you will sometimes need to show PDF for some reason (e.g. help manual). A lot of Java PDF libraries are available out there, but all of them are difficult to use, and need a lot of time and brain power to understand and use. This library promises to be ridiculously easy to use. A few lines of code and you get a PDF page, ready to show on your program. 
# How to use the library
As promised, the library is very easy to use. See the examples below.
## Getting started
The following code shows how to get the first page of a PDF file. It is pretty straight forward.

        PDFReaderExample prog = new PDFReaderExample();
        PDFReader pdfReader = new PDFReader();
        // parse the PDF document
        prog.pdfDocument = pdfReader.parse("/path/to/file.pdf");
        if(prog.pdfDocument == null) {
            System.out.println("Failed to open PDF. Error: " + pdfReader.getLastError());
            return;
        }
        // get the page count
        int pageCount = prog.pdfDocument.getPageCount();
        if(pageCount > 0) {
                // load the first page as an image
                BufferedImage page = pdfDocument.getPage(0);
                if(page != null) {
                    // show the image on your JFrame or whatever
                }
        } else {
            System.out.println("Failed to get PDF page count.");
        }

## A more complex example
The file `PDFReaderExample.java` under the `reader` source folder contains a fairly decent PDF viewer that opens a PDF file and shows it one page at a time. The comments in the code should make it easy to follow, and edit, the example.

# License
This library is licensed under GNU Lesser General Public License (LGPL) v3.0. This is because many of you will need to include the PDF library in your proprietary or closed source programs, which is fine by me.
