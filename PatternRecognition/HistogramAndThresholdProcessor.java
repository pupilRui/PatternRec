package PatternRecognition;
public class HistogramAndThresholdProcessor {

    public static int[][] performHistogramThresholding(int[][] inputMatrix, int threshold) {
        int numRows = inputMatrix.length;
        int numCols = inputMatrix[0].length;
        int[][] binaryMatrix = new int[numRows][numCols];

        // Perform histogram analysis and thresholding
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (inputMatrix[i][j] >= threshold) {
                    binaryMatrix[i][j] = 1; // Set as 1 if above or equal to the threshold
                } else {
                    binaryMatrix[i][j] = 0; // Set as 0 if below the threshold
                }
            }
        }

        return binaryMatrix;
    }
}
