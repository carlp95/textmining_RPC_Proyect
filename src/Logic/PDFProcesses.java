package Logic;

import com.sun.org.apache.bcel.internal.classfile.LineNumber;
import org.apache.commons.compress.compressors.FileNameUtil;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import javax.xml.stream.FactoryConfigurationError;
import java.io.*;
import java.util.Scanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        File directory = new File("resources/papers/"); //Directory of the resources
        File[] directoryfiles = directory.listFiles(); //List of files that are in that directory

        if (directoryfiles != null){ //If the directory have files it can do everything
            for (File child: directoryfiles) { //files iteration

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

    public void OneDocumentToText(File fileparam) {
        this.pdfStripper = null;
        this.pdDoc = null;
        this.cosDoc = null;

        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            //String fileName = child.getName();
            //System.out.println(child.getPath());
            fw = new FileWriter(fileparam.getPath().replace(".pdf", ".txt"));
            bw = new BufferedWriter(fw);
            parser = new PDFParser(new RandomAccessFile(fileparam, "r")); // update for PDFBox V 2.0

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

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }
    //private void setFilePath(String filePath) {
     //   this.filePath = filePath;
    //}

    public void CleanDocumentText()
    {
        BufferedWriter bw = null;
        FileWriter fw = null;
        int CleanNumber = 5000000;
        String line;
        String line2;

        File directory = new File("resources/papers/"); //Directory of the resources
        File[] directoryfiles = directory.listFiles(); //List of files that are in that directory


        if (directoryfiles != null) { //If the directory have files it can do everything
            for (File child : directoryfiles) { //files iteration


                if(getFileExtension(child).equals("txt")){
                try
                {
                    fw = new FileWriter("resources/papers/"+child.getName()+"_cleaned.txt");
                    bw = new BufferedWriter(fw);
                    Scanner scanner = null;
                    scanner = new Scanner(child);
                    int lineNum = 0;
                    int lineNum2 = 0;
                    Boolean bool = false;

                    while (scanner.hasNextLine())
                    {
                        line = scanner.nextLine();
                        if(line.contains("Abstract") || line.contains("abstract"))
                        {
                            bool=true;
                        }
                        if(bool)
                        {
                            if (line.contains("introduction") || line.contains("Introduction"))
                            {
                                CleanNumber = lineNum;
                                System.out.println(CleanNumber);
                            }
                            if(lineNum<CleanNumber)
                            {
                                bw.write(line);
                            }
                        }
                        lineNum++;
                    }

                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    try
                    {
                        if (bw != null)
                        {
                            bw.close();
                        }
                        if (fw != null)
                        {
                            fw.close();
                        }
                    } catch (IOException ex)
                    {
                        ex.printStackTrace();
                    }

                }
                }
            }
        }

    }

    private String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
}
