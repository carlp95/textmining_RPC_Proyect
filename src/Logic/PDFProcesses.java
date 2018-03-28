package Logic;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PDFProcesses {
    private PDFParser parser;
    private PDFTextStripper pdfStripper;
    private PDDocument pdDoc ;
    private COSDocument cosDoc ;

    private String Text ;

    private File file;

    public PDFProcesses(){

    }

    public void ToText() throws IOException
    {
        this.pdfStripper = null;
        this.pdDoc = null;
        this.cosDoc = null;

        File directory = new File("resources/papers/");
        File[] directoryfiles = directory.listFiles();

        if (directoryfiles != null){
            for (File child: directoryfiles) {

                BufferedWriter bw = null;
                FileWriter fw = null;

                try {
                    //String fileName = child.getName();
                    //System.out.println(child.getPath());
                    fw = new FileWriter(child.getPath().replace(".pdf",".txt"));
                    bw = new BufferedWriter(fw);
                    parser = new PDFParser(new RandomAccessFile(child,"r")); // update for PDFBox V 2.0

                    parser.parse();
                    cosDoc = parser.getDocument();
                    pdfStripper = new PDFTextStripper();
                    pdDoc = new PDDocument(cosDoc);
                    pdDoc.getNumberOfPages();
                    pdfStripper.setStartPage(1);
                    //pdfStripper.setEndPage(10);

                    // reading text from page 1 to 10
                    // if you want to get text from full pdf file use this code
                    pdfStripper.setEndPage(pdDoc.getNumberOfPages());

                    Text = pdfStripper.getText(pdDoc);
                    bw.write(Text);

                }catch (IOException e){
                    e.printStackTrace();
                }finally {
                    try {
                        if (bw != null){
                            bw.close();
                        }
                        if (fw != null){
                            fw.close();
                        }
                    }catch (IOException ex){
                        ex.printStackTrace();
                    }
                }
            }
        }
        //return Text;
    }

    //private void setFilePath(String filePath) {
     //   this.filePath = filePath;
    //}


}
