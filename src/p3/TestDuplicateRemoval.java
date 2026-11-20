package p3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TestDuplicateRemoval {
    
    // remove duplicates
    public static void removeDuplicate(ArrayList<Integer> list) {
        ArrayList<Integer> uniqueList = new ArrayList<>();
        for (Integer uniqueNum : list) {
            if (!uniqueList.contains(uniqueNum)) {
                uniqueList.add(uniqueNum);
            }
        }

        list.clear();
        list.addAll(uniqueList);
    }

    
    
    // main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("Enter 10 integers:");
        for (int i = 0; i < 10; i++) {
            numbers.add(scanner.nextInt());
        }

        removeDuplicate(numbers);

        // input order
        System.out.println("\nDistinct integers in input order:");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
            System.out.print(" ");
        }
        System.out.println();
        System.out.println();
        
        // increasing order
        Collections.sort(numbers); 
        System.out.println("Distinct integers in increasing order:");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
            System.out.print(" ");
        }
        System.out.println();
        
        scanner.close();
    }
}
