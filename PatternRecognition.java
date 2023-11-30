/**
 * PatternRecognition
 */
import java.io.*;
import java.util.List;
import PatternRecognition.*;
import PatternRecognition.BMPToGrayscale;
import PatternRecognition.ConnectivityAnalyzer;
import PatternRecognition.HistogramAndThresholdProcessor;
public class PatternRecognition {

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BMPToGrayscale bmpToGrayscale = new BMPToGrayscale("output_10x10.bmp");

        int[][] grayImage = bmpToGrayscale.getGrayscalePixels();

        System.out.println("After Step A: Gray level image:");
        printMatrix(grayImage);

        int[][] binaryImage = HistogramAndThresholdProcessor.performHistogramThresholding(grayImage, 156);
        System.out.println("After Step B: Binary image:");
        printMatrix(binaryImage);

        int[][] connectImage = ConnectivityAnalyzer.performConnectivityAnalysis(binaryImage);
        System.out.println("After Step C: Connectivity Analysis:");
        printMatrix(connectImage);

        List<ObjectAttributes> objectAttributesList = ObjectRecognizer.computeObjectAttributes(connectImage);
        System.out.println("After Step D: Object Attributes:");
        for (ObjectAttributes objectAttributes : objectAttributesList) {
            System.out.println(objectAttributes);
        }
    }

}