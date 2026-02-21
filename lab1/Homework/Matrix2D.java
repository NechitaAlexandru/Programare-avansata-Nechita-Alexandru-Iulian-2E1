void main() {
    int smallN = 20;
    System.out.println("--- Generam pt (n = " + smallN + ") ---");

    int[][] smallRectangle = createRectangle(smallN);
    int[][] smallCircle = createCircle(smallN);

    System.out.println("Rectangle Image:");
    System.out.println(buildMatrixString(smallRectangle));

    System.out.println("Circle Image:");
    System.out.println(buildMatrixString(smallCircle));

    int largeN = 28048; //pt 28049 primim out of memory
    System.out.println("\n--- Testare (n = " + largeN + ") ---");

    long startTime = System.nanoTime();

    createRectangle(largeN);
    createCircle(largeN);

    long endTime = System.nanoTime();
    long durationMs = (endTime - startTime) / 1_000_000;

    System.out.println("Generare cu succes.");
    System.out.println("Timp total executie: " + (endTime - startTime) + " ns (" + durationMs + " ms)");
}

public static int[][] createRectangle(int n) {
    int[][] image = new int[n][n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (i >= n / 4 && i < 3 * n / 4 && j >= n / 4 && j < 3 * n / 4) {
                image[i][j] = 0;
            } else {
                image[i][j] = 255;
            }
        }
    }
    return image;
}

public static int[][] createCircle(int n) {
    int[][] image = new int[n][n];
    double center = (n-1) / 2.0;
    double radius = (double) n / 4   ;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            double dx = i - center;
            double dy = j - center;

            if ((dx * dx) + (dy * dy) <= (radius * radius)) {
                image[i][j] = 255;
            }
        }
    }
    return image;
}

public static String buildMatrixString(int[][] image) {
    StringBuilder sb = new StringBuilder();

        char darkPixel = '\u2591';
        char whitePixel ='\u2588';

    for (int i = 0; i < image.length; i++) {
        for (int j = 0; j < image[i].length; j++) {
            if (image[i][j] == 0) {
                sb.append(darkPixel).append(darkPixel);
            } else {
                sb.append(whitePixel).append(whitePixel);
            }
        }
        sb.append("\n");
    }

    return sb.toString();
}