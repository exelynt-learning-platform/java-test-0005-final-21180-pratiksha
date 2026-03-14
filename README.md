# java-test-0005-final-21180-pratiksha
Final Project Assignment - This repository contains the complete final project code and documentation.
public class NumberPattern {
    public static void main(String[] args) {
        int num = 1;

        for (int i = 1; i <= 5; i++) {   
            for (int j = 1; j <= i; j++) { 
                System.out.print(num + " ");
                num++;
            }
            System.out.println(); 
        }
    }
}
