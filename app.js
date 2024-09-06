const PDFDocument = require('pdfkit');
const fs = require('fs');

const doc = new PDFDocument;

doc.text('test');

doc.pipe(fs.createWriteStream('./pdf/file.pdf')); // write to PDF

doc.end();
