package Logic;

import Visual.ResultDialog;
import weka.core.*;
import weka.core.FastVector;
import weka.classifiers.meta.FilteredClassifier;

import javax.swing.*;
import java.util.ArrayList;
import java.io.*;

public class Classifier {

    /**
     * String that stores the text to classify
     */
    String text;
    /**
     * Object that stores the instance.
     */
    Instances instances;
    /**
     * Object that stores the classifier.
     */
    FilteredClassifier classifier;

    File archivo_aux;
    public String Ruta;
    public  String pertenece;
    ResultDialog result;


    public Classifier(){
        this.archivo_aux = new File("resources/baklog.txt");
    }

    /**
     * This method loads the text to be classified.
     * @param fileName The name of the file that stores the text.
     */
    public void load(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            text = "";
            while ((line = reader.readLine()) != null) {
                text = text + " " + line;
            }
            //System.out.println("===== Archivo cargado: " + fileName + " =====");
            reader.close();
            //System.out.println(text);
            Ruta = fileName;

            FileWriter fw = null;
            BufferedWriter bw = null;

            fw = new FileWriter(this.archivo_aux,true);
            bw = new BufferedWriter(fw);

            bw.write("===== Archivo cargado: " + fileName + " =====" + "\n");
            bw.write(text);
            bw.close();
            fw.close();
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar el archivo seleccionado, chequee que tenga contenido o que exista", "Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method loads the model to be used as classifier.
     * @param fileName The name of the file that stores the text.
     */
    public void loadModel(String fileName) {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            Object tmp = in.readObject();
            classifier = (FilteredClassifier) tmp;
            in.close();
            //System.out.println("===== Modelo Cargado: " + fileName + " =====");

            FileWriter fw = null;
            BufferedWriter bw = null;

            fw = new FileWriter(this.archivo_aux,true);
            bw = new BufferedWriter(fw);

            bw.write("===== Modelo Cargado: " + fileName + " =====" + "\n");
            bw.close();
            fw.close();
        }
        catch (Exception e) {
            // Given the cast, a ClassNotFoundException must be caught along with the IOException
            JOptionPane.showMessageDialog(null, "No se pudo cargar el modelo", "Error",JOptionPane.ERROR_MESSAGE);
            //System.out.println("Problem found when reading: " + fileName);
        }

    }

    /**
     * This method creates the instance to be classified, from the text that has been read.
     */
    public void makeInstance() {
        // Create the attributes, class and text
        ArrayList<String> fvNominalVal = new ArrayList<>(4);
        fvNominalVal.add("association");
        fvNominalVal.add("classification");
        fvNominalVal.add("clustering");
        fvNominalVal.add("prediction");
        Attribute attribute1 = new Attribute("class", fvNominalVal);
        Attribute attribute2 = new Attribute("text",(ArrayList<String>) null);
        // Create list of instances with one element
        ArrayList<Attribute> fvWekaAttributes = new ArrayList<>(2);
        fvWekaAttributes.add(attribute1);
        fvWekaAttributes.add(attribute2);
        instances = new Instances("Test relation", fvWekaAttributes, 1);
        // Set class index
        instances.setClassIndex(0);
        // Create and add the instance
        DenseInstance instance = new DenseInstance(2);
        instance.setValue(attribute2, text);
        // Another way to do it:
        // instance.setValue((Attribute)fvWekaAttributes.elementAt(1), text);
        instances.add(instance);
        //System.out.println("===== Instance created with reference dataset =====");
        //System.out.println(instances);

        FileWriter fw = null;
        BufferedWriter bw = null;
        try{

            fw = new FileWriter(this.archivo_aux,true);
            bw = new BufferedWriter(fw);

            bw.write("===== Instancias creadas con el dataset referenciado =====" + "\n");
            bw.write(instances.toString() + "\n");
        }catch (IOException e){
            e.printStackTrace();
        }finally
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

    /**
     * This method performs the classification of the instance.
     * Output is done at the command-line.
     */
    public void classify() {
        try {
            double pred = classifier.classifyInstance(instances.instance(0));
            //System.out.println("===== Classified instance =====");
            //System.out.println("Class predicted: " + instances.classAttribute().value((int) pred));
            pertenece = instances.classAttribute().value((int) pred);
            FileWriter fw = null;
            BufferedWriter bw = null;

            fw = new FileWriter(this.archivo_aux,true);
            bw = new BufferedWriter(fw);

            bw.write("===== Clasificación de la instancia nueva =====" +"\n");
            bw.write("Clasificado como: " + instances.classAttribute().value((int) pred) + "\n");
            bw.close();
            fw.close();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al clasificar el texto", "Error",JOptionPane.ERROR_MESSAGE);
            //System.out.println("Problem found when classifying the text");
        }
    }
}
