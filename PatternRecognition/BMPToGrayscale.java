package PatternRecognition;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BMPToGrayscale {

    private int[][] grayscalePixels;

    public BMPToGrayscale(String inputFilePath) {
        try {
            // Load the BMP image
            BufferedImage image = ImageIO.read(new File(inputFilePath));

            // Convert to grayscale
            BufferedImage grayImage = convertToGrayscale(image);

            // Get the grayscale image as a 2D integer array
            grayscalePixels = getGrayscalePixels(grayImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Convert an image to grayscale
    private BufferedImage convertToGrayscale(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage grayImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = new Color(image.getRGB(x, y));
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();
                int grayValue = (red + green + blue) / 3;
                int grayPixel = new Color(grayValue, grayValue, grayValue).getRGB();
                grayImage.setRGB(x, y, grayPixel);
            }
        }

        return grayImage;
    }

    // Get the grayscale image as a 2D integer array
    private int[][] getGrayscalePixels(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        int[][] pixels = new int[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = new Color(image.getRGB(x, y));
                int grayValue = color.getRed(); // Red, Green, and Blue channels are the same in grayscale
                pixels[y][x] = grayValue;
            }
        }

        return pixels;
    }

    public int[][] getGrayscalePixels() {
        return grayscalePixels;
    }

    public static void main(String[] args) {
        BMPToGrayscale converter = new BMPToGrayscale("input.bmp");

        // Access the grayscale pixel values
        int[][] grayscalePixels = converter.getGrayscalePixels();

        // Print the first few rows and columns of the grayscale image
        int numRowsToPrint = 5;
        int numColsToPrint = 5;
        for (int i = 0; i < numRowsToPrint; i++) {
            for (int j = 0; j < numColsToPrint; j++) {
                System.out.print(grayscalePixels[i][j] + " ");
            }
            System.out.println();
        }
    }
}
