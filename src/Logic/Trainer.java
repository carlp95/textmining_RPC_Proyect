package Logic;

import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;
import weka.classifiers.Evaluation;
import java.util.Random;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.meta.FilteredClassifier;
import weka.core.converters.ArffLoader.ArffReader;
import java.io.*;

public class Trainer {
    /**
     * Object that stores training data.
     */
    Instances trainData;
    /**
     * Object that stores the filter
     */
    StringToWordVector filter;
    /**
     * Object that stores the classifier
     */
    FilteredClassifier classifier;

    /**
     * This method loads a dataset in ARFF format. If the file does not exist, or
     * it has a wrong format, the attribute trainData is null.
     * @param fileName The name of the file that stores the dataset.
     */
    public void loadDataset(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            ArffReader arff = new ArffReader(reader);
            trainData = arff.getData();
            System.out.println("===== Loaded dataset: " + fileName + " =====");
            reader.close();
        }
        catch (IOException e) {
            System.out.println("Problem found when reading: " + fileName);
        }
    }

    /**
     * This method evaluates the classifier. As recommended by WEKA documentation,
     * the classifier is defined but not trained yet. Evaluation of previously
     * trained classifiers can lead to unexpected results.
     */
    public void evaluate() {
        try {
            trainData.setClassIndex(1);
            filter = new StringToWordVector();
            filter.setAttributeIndices("first");
            classifier = new FilteredClassifier();
            classifier.setFilter(filter);
            classifier.setClassifier(new NaiveBayes());
            Evaluation eval = new Evaluation(trainData);
            eval.crossValidateModel(classifier, trainData, 5, new Random(35));
            System.out.println(eval.toSummaryString());
            System.out.println(eval.toClassDetailsString());
            System.out.println("===== Evaluating on filtered (training) dataset done =====");
        }
        catch (Exception e) {
            System.out.println("Problem found when evaluating");
        }
    }

    /**
     * This method trains the classifier on the loaded dataset.
     */
    public void learn() {
        try {
            trainData.setClassIndex(1);
            filter = new StringToWordVector();
            filter.setAttributeIndices("first");
            classifier = new FilteredClassifier();
            classifier.setFilter(filter);
            classifier.setClassifier(new NaiveBayes());
            classifier.buildClassifier(trainData);
            // Uncomment to see the classifier
             //System.out.println(classifier);
            System.out.println("===== Training on filtered (training) dataset done =====");
        }
        catch (Exception e) {
            System.out.println("Problem found when training");
        }
    }

    /**
     * This method saves the trained model into a file. This is done by
     * simple serialization of the classifier object.
     * @param fileName The name of the file that will store the trained model.
     */
    public void saveModel(String fileName) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            out.writeObject(classifier);
            out.close();
            System.out.println("===== Saved model: " + fileName + " =====");
        }
        catch (IOException e) {
            System.out.println("Problem found when writing: " + fileName);
        }
    }
}
