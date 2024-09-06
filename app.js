import PDFDocument from 'pdfkit';
import { checkFiles} from './config.js';


await checkFiles();

const doc = new PDFDocument;

doc.text('test');

//doc.pipe(fs.createWriteStream('./pdf/file.pdf')); // write to PDF

doc.end();
