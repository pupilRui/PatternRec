package PatternRecognition;
import java.util.ArrayList;
import java.util.List;

public class ObjectRecognizer {

    private static int area;
    private static int perimeter;

    public static List<ObjectAttributes> computeObjectAttributes(int[][] binaryImage) {
        int numRows = binaryImage.length;
        int numCols = binaryImage[0].length;

        List<ObjectAttributes> objectAttributesList = new ArrayList<>();
        boolean[][] visited = new boolean[numRows][numCols];

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (binaryImage[row][col] != 0 && !visited[row][col]) {
                    area = 0;
                    perimeter = 4;
                    dfs(binaryImage, visited, row, col, numRows, numCols);
                    objectAttributesList.add(new ObjectAttributes(area, perimeter));
                }
            }
        }

        return objectAttributesList;
    }

    private static boolean dfs(int[][] binaryImage, boolean[][] visited, int row, int col, int numRows, int numCols) {
        if (row < 0 || row >= numRows || col < 0 || col >= numCols || binaryImage[row][col] == 0 || visited[row][col]) {
            return false;
        }

        visited[row][col] = true;
        area++;

        int cnt = 0;

        dfs(binaryImage, visited, row + 1, col, numRows, numCols);
        int row1 = row + 1;
        int col1 = col;
        if (!(row1 < 0 || row1 >= numRows || col1 < 0 || col1 >= numCols || binaryImage[row1][col1] == 0))
        {
            cnt++;
        }
        dfs(binaryImage, visited, row - 1, col, numRows, numCols);
        row1 = row - 1;
        col1 = col;
        if (!(row1 < 0 || row1 >= numRows || col1 < 0 || col1 >= numCols || binaryImage[row1][col1] == 0))
        {
            cnt++;
        }
        dfs(binaryImage, visited, row, col + 1, numRows, numCols);
        row1 = row;
        col1 = col + 1;
        if (!(row1 < 0 || row1 >= numRows || col1 < 0 || col1 >= numCols || binaryImage[row1][col1] == 0))
        {
            cnt++;
        }
        dfs(binaryImage, visited, row, col - 1, numRows, numCols);
        row1 = row;
        col1 = col - 1;
        if (!(row1 < 0 || row1 >= numRows || col1 < 0 || col1 >= numCols || binaryImage[row1][col1] == 0))
        {
            cnt++;
        }

        if (cnt <= 3) {
            perimeter++;
        }

        return true;
    }

}
