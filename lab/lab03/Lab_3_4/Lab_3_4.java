package Lab_3.Lab_3_4 ;

import java.util.InputMismatchException ;
import java.util.Scanner ;

class Product {
    private final String name ;
    private static int productCount = 0 ;

    public Product(String name) {
        this.name = name ;
        productCount++ ;
    }

    public String getName() {
        return name ;
    }

    public static int getProductCount() {
        return productCount ;
    }
}

public class Lab_3_4 {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int productNumber = readPositiveInt(input, "Enter Product Number : ") ;
            if (productNumber <= 0) {
                System.out.println(0) ;
                return ;
            }

            for (int i = 0; i < productNumber; i++) {
                String productName = readNonEmptyLine(input, "Enter Product Name : ") ;
                new Product(productName) ;
            }

            System.out.println(Product.getProductCount()) ;
        }
    }

    private static int readPositiveInt(Scanner input, String prompt) {
        while (true) {
            System.out.print(prompt) ;
            try {
                int n = input.nextInt() ;
                input.nextLine() ;
                if (n > 0) return n ;
                System.out.println("Please enter a positive integer greater than 0.") ;
            } catch (InputMismatchException e) {
                input.nextLine() ;
                System.out.println("Please enter a valid integer.") ;
            }
        }
    }

    private static String readNonEmptyLine(Scanner input, String prompt) {
        while (true) {
            System.out.print(prompt) ;
            String line = input.nextLine().trim() ;
            if (!line.isEmpty()) return line ;
            System.out.println("Product name should not be empty.") ;
            }
    }
}