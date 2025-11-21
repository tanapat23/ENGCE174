package lab1_2;
import java.util.*;
public class lab1_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner( System.in );
		System.out.print("Please Enter Width : ");
        double width = sc.nextDouble();
        System.out.print("Please Enter Height : ");
        double height = sc.nextDouble();
        System.out.println("Area = "+(width * height));
        sc.close();
	}

}
