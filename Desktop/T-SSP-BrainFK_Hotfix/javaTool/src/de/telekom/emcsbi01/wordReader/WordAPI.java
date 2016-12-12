package de.telekom.emcsbi01.wordReader;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Class to handle Word-Documents in *.docx type. Not working on old *.doc format. <br>
 * @author Nico Remus <br>
 * @coauthor Philipp Staats<br>
 * T-System Internationl GmbH<br>
 * @version 1.0
 */
public class WordAPI {
    private XWPFDocument wordFile;

    /**
     * Constructor - create new Word-Object
     */
    public WordAPI(){
        wordFile = new XWPFDocument();
    }

    /**
     * Constructor overload - create new Word - Object on existing word-file
     * @param in {@link java.io.InputStream} - Use {@link IO}
     */
    public WordAPI(FileInputStream in) throws IOException {
        try {
            wordFile = new XWPFDocument(OPCPackage.open(in));
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    }

    /**
     * class to write whole content of word file on the cmd console
     */
    public void readCompleteWordFile(){
        try {
            XWPFWordExtractor extractor = new XWPFWordExtractor(wordFile);
            System.out.println(extractor.getText());
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        /*List<XWPFParagraph> list = wordFile.getParagraphs();
        for (XWPFParagraph paragraph: list){
            System.out.println(paragraph.getText());
        }*/
    }
}
