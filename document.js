import PDFDocument from 'pdfkit';
import fs from 'fs';

function makePDF(){
    const doc = new PDFDocument({size: 'LETTER'});


    // HEADER
    doc.fontSize(16);
    doc.font('Helvetica-Bold');
    doc.fillColor('cornflowerblue');
    doc.text('Your Name');

    doc.moveDown(0.1);

    doc.fontSize(11);
    doc.font('Helvetica');
    doc.fillColor('black');
    doc.text('email | website1 | website2 | Location | etc');

    doc.moveDown();


    // Skills
    doc.fontSize(14);
    doc.font('Helvetica-Bold');
    doc.fillColor('cornflowerblue');
    doc.text('Skills');


    doc.fontSize(11);
    doc.font('Helvetica');
    doc.fillColor('black');

    for(let i = 1; i < 5; i++){
        doc.moveDown(0.1);
        doc.text('skill #' + i);
    }

    const expId = ['Experience: ', 'Additional Experience'];
    //EXPERIENCE
    for(let i = 0; i < 2; i++){

        doc.moveDown();
        doc.fontSize(14);
        doc.font('Helvetica-Bold');
        doc.fillColor('cornflowerblue');
        doc.text(expId[i]);



        doc.fontSize(11);
        doc.font('Helvetica');
        doc.fillColor('black');

        for(let j = 1; j < 4; j++){
            if(i === 1 && j === 1){
                continue;
            }
            doc.moveDown(0.3);
            doc.font('Helvetica-Bold');
            doc.text('Experience Title #' + j); // title
            doc.moveDown(0.3);
            doc.font('Helvetica-Oblique');
            doc.text('elaborate');

            if(i === 0){
                doc.list(['1','2','3'], {
                    indent: 20,
                });
            } else {
                doc.list(['1','2'], {
                    indent: 20,
                });
            }

        }


    }
    // EDUCATION

    doc.moveDown();
    doc.fontSize(14);
    doc.font('Helvetica-Bold');
    doc.fillColor('cornflowerblue');
    doc.text('Education');

    doc.fontSize(11);
    doc.font('Helvetica');
    doc.fillColor('black');
    for(let i = 1; i < 3; i++){
        doc.moveDown(0.1);
        doc.text('Education #' + i);
    }
    ///END

    doc.pipe(fs.createWriteStream('./pdf/file.pdf'));

    doc.end();
}

export{ makePDF }
