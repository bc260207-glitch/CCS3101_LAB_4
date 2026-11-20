package p1;

import java.util.ArrayList;

//Superclass Car
class Car {
 private int speed;
 private String regularPrice;
 private String color;

 public Car(int speed, String regularPrice, String color) {
     this.speed = speed;
     this.regularPrice = regularPrice;
     this.color = color;
 }

 public double SalePrice() {
     return Double.parseDouble(regularPrice);
 }

 @Override
 public String toString() {
     return "Color: " + color + ", Speed: " + speed + ", Regular Price: RM" + regularPrice;
 }
}



//Subclass MPV
class MPV extends Car {
 private int length;

 public MPV(int speed, String regularPrice, String color, int length) {
     super(speed, regularPrice, color);
     this.length = length;
 }

 @Override
 public double SalePrice() {
     double basePrice = super.SalePrice();
     if (length > 15) {
         return basePrice * 0.85;
     } else {
         return basePrice * 0.80;
     }
 }

 @Override
 public String toString() {
     return "MPV [" + super.toString() + ", Length: " + length + "feet]";
 }
}



//Subclass Sedan
class Sedan extends Car {
 private int year;
 private int manufacturerDiscount;

 public Sedan(int speed, String regularPrice, String color, int year, int manufacturerDiscount) {
     super(speed, regularPrice, color);
     this.year = year;
     this.manufacturerDiscount = manufacturerDiscount;
 }

 @Override
 public double SalePrice() {
     return super.SalePrice() - manufacturerDiscount;
 }

 @Override
 public String toString() {
     return "Sedan [" + super.toString() + ", Year: " + year + "]";
 }
}



//Subclass Caravan
class Caravan extends Car {
 private int weight;

 public Caravan(int speed, String regularPrice, String color, int weight) {
     super(speed, regularPrice, color);
     this.weight = weight;
 }

 @Override
 public double SalePrice() {
     double basePrice = super.SalePrice();
     if (weight > 2500) {
         return basePrice * 0.95; 
     } else {
         return basePrice * 0.90; 
     }
 }

 @Override
 public String toString() {
     return "Caravan [" + super.toString() + ", Weight: " + weight + "kg]";
 }
}



//Test main
public class TestCar {
 public static void main(String[] args) {
     ArrayList<Car> carList = new ArrayList<>();
     
     carList.add(new MPV(120, "100000", "Black", 16));
     carList.add(new Sedan(150, "80000", "White", 2022, 5000));
     carList.add(new Caravan(100, "120000", "Silver", 3000));
     carList.add(new Caravan(100, "1200", "Gold", 200));

     for (Car testCar : carList) {
         System.out.println(testCar.toString());
         System.out.println("Sale Price: RM " + String.format("%.2f", testCar.SalePrice()));
         System.out.println("-----------------------------");
     }
 }
}