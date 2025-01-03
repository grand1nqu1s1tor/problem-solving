import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        // Go right, + top boundary/row
        // Go down, - right boundary/col
        // Go left, - bottom boundary/row
        // Go up, + left boundary/col
        // Repeat

        List<Integer> spiral = new ArrayList();
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = matrix.length;
        int colEnd = matrix[0].length;

        while (rowStart < rowEnd && colStart < colEnd) {

            for (int j = colStart; j < colEnd; j++) {
                spiral.add(matrix[rowStart][j]);
            }
            rowStart++;

            for (int i = rowStart; i < rowEnd; i++) {
                spiral.add(matrix[i][colEnd - 1]);
            }
            colEnd--;

            if (rowStart < rowEnd) {
                for (int j = colEnd - 1; j >= colStart; j--) {
                    spiral.add(matrix[rowEnd - 1][j]);
                }
                rowEnd--;
            }

            if (colStart < colEnd) {
                for (int i = rowEnd - 1; i >= rowStart; i--) {
                    spiral.add(matrix[i][colStart]);
                }
                colStart++;
            }
        }
        return spiral;

    }
}