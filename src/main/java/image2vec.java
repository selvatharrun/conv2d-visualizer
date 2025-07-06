import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//this function is to convert rgb to grayscale and store it coz we aint doing 3d convolution, we trynna afford 2d here.

public class image2vec {
    public static int[][] convertToGrayscaleMatrix(String imagePath) throws IOException {
        BufferedImage img = ImageIO.read(new File(imagePath));

        int width = img.getWidth();
        int height = img.getHeight();
        int[][] matrix = new int[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = img.getRGB(x, y);

                int r = (rgb >> 16) & 0xFF;
                int g = (rgb >> 8) & 0xFF;
                int b = rgb & 0xFF;

                // Convert to grayscale using luminance formula
                int gray = (int)(0.299 * r + 0.587 * g + 0.114 * b);

                matrix[y][x] = gray; // You now have a matrix of grayscale intensities [0-255]
            }
        }

        return matrix;
    }
}
