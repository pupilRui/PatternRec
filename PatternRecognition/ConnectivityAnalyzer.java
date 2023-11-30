package PatternRecognition;
public class ConnectivityAnalyzer {

    private static int[][] binaryImage;
    private static int numRows;
    private static int numCols;
    private static int currentRegion;

    public static int[][] performConnectivityAnalysis(int[][] inputBinaryImage) {
        numRows = inputBinaryImage.length;
        numCols = inputBinaryImage[0].length;
        binaryImage = inputBinaryImage;
        currentRegion = 1; // Starting from region number 1

        int[][] labeledImage = new int[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (binaryImage[i][j] == 1 && labeledImage[i][j] == 0) {
                    floodFill(i, j, labeledImage);
                    currentRegion++;
                }
            }
        }

        return labeledImage;
    }

    private static void floodFill(int row, int col, int[][] labeledImage) {
        if (row < 0 || row >= numRows || col < 0 || col >= numCols) {
            return;
        }

        if (binaryImage[row][col] == 0 || labeledImage[row][col] != 0) {
            return;
        }

        labeledImage[row][col] = currentRegion;

        floodFill(row + 1, col, labeledImage); // Check below
        floodFill(row - 1, col, labeledImage); // Check above
        floodFill(row, col + 1, labeledImage); // Check right
        floodFill(row, col - 1, labeledImage); // Check left
    }
}
