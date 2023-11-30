package PatternRecognition;

public class ObjectAttributes {
    private int area;
    private int perimeter; // Add perimeter attribute

    public ObjectAttributes(int area, int perimeter) {
        this.area = area;
        this.perimeter = perimeter;
    }

    public int getArea() {
        return area;
    }

    public int getPerimeter() {
        return perimeter;
    }

    public String getObjectShape() {
        double circularity = (4 * Math.PI * area) / (perimeter * perimeter);
        System.out.println(circularity);

        if (Math.abs(circularity - Math.PI / 4) < 0.01) {
            return "Square";
        } else {
            return "Circular";
        }
    }

    @Override
    public String toString() {
        return "Area: " + area + ", Perimeter: " + perimeter + ", Shape: " + getObjectShape();
    }
}