package Advanced;

public class BoundingBoxFinder {

    public static void findBoundary(boolean[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            System.out.println("Matrix is empty.");
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;


        int minRow = m;
        int maxRow = -1;
        int minCol = n;
        int maxCol = -1;


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (matrix[i][j]) {

                    if (i < minRow) minRow = i;
                    if (i > maxRow) maxRow = i;
                    if (j < minCol) minCol = j;
                    if (j > maxCol) maxCol = j;
                }
            }
        }


        if (maxRow == -1) {
            System.out.println("No shape found in the matrix.");
        } else {
            System.out.println("Bounding Box found at:");
            System.out.println("Top-Left: (" + minRow + ", " + minCol + ")");
            System.out.println("Bottom-Right: (" + maxRow + ", " + maxCol + ")");
        }
    }

    static void main() {

        boolean[][] exemplu = {
                {false, false, false, false, false},
                {false, true,  true,  false, false},
                {false, false, true,  true,  false},
                {false, false, false, false, false}
        };

        findBoundary(exemplu);
    }
}