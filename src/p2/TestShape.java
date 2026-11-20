package p2;

import java.util.ArrayList;

abstract class Shape {
    public abstract double calArea();
}

abstract class TwoDimensional extends Shape {
}

abstract class ThreeDimensional extends Shape {
    public abstract double calVolume();
}



// 2D
class Circle extends TwoDimensional {
    private double radius;
    public Circle(double radius) { this.radius = radius; }
    @Override
    public double calArea() { return Math.PI * radius * radius; }
    @Override
    public String toString() { return "Circle (radius=" + radius + ")"; }
}

class Triangle extends TwoDimensional {
    private double base, height;
    public Triangle(double base, double height) { this.base = base; this.height = height; }
    @Override
    public double calArea() { return 0.5 * base * height; }
    @Override
    public String toString() { return "Triangle (base=" + base + ", height=" + height + ")"; }
}

class Square extends TwoDimensional {
    private double side;
    public Square(double side) { this.side = side; }
    @Override
    public double calArea() { return side * side; }
    @Override
    public String toString() { return "Square (side=" + side + ")"; }
}



// 3D
class Cube extends ThreeDimensional {
    private double side;
    public Cube(double side) { this.side = side; }
    @Override
    public double calArea() { return 6 * side * side; } 
    @Override
    public double calVolume() { return side * side * side; }
    @Override
    public String toString() { return "Cube (side=" + side + ")"; }
}

class Sphere extends ThreeDimensional {
    private double radius;
    public Sphere(double radius) { this.radius = radius; }
    @Override
    public double calArea() { return 4 * Math.PI * radius * radius; } 
    @Override
    public double calVolume() { return (4.0/3.0) * Math.PI * Math.pow(radius, 3); }
    @Override
    public String toString() { return "Sphere (radius=" + radius + ")"; }
}

// Test main
public class TestShape {
    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>();
        
        shapes.add(new Circle(5));
        shapes.add(new Triangle(4, 6));
        shapes.add(new Square(4));
        shapes.add(new Cube(3));
        shapes.add(new Sphere(5));

        System.out.println("--- Display calArea() ---");
        for (Shape testShape : shapes) {
            System.out.printf("%s -> Area: %.2f\n", testShape.toString(), testShape.calArea());
        }
        
        System.out.println("\n--- Display calVolume() ---");
        for (Shape testShape : shapes) {
            if (testShape instanceof ThreeDimensional) {
                ThreeDimensional tdShape = (ThreeDimensional) testShape;
                System.out.printf("%s -> Volume: %.2f\n", tdShape.toString(), tdShape.calVolume());
            }
        }
        
		/*
		 * System.out.println("--- Display calVolume() ---"); for (Shape testShape2 :
		 * shapes) { System.out.printf("%s -> Volume: %.2f\n", testShape2.toString(), testShape2.calVolume()); }
		 * ---not work
		 */
    }
}