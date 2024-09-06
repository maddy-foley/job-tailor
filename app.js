import PDFDocument from 'pdfkit';
import fs from 'fs';
import sqlite3 from 'sqlite3';
import { makeDatabase } from './db.js';


const db = new sqlite3.Database(':memory:');

makeDatabase(db);


const doc = new PDFDocument;

doc.text('test');

doc.pipe(fs.createWriteStream('./pdf/file.pdf')); // write to PDF

doc.end();
