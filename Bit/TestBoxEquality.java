package box;
import java.util.Scanner;

public class TestBoxEquality {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Box 1 Diamensions");
		Box b1 = new Box(sc.nextInt(), sc.nextInt(), sc.nextInt());
		System.out.println("Box1: "+b1.getBoxDiam());
		
		System.out.println("Enter Box 2 Diamensions");
		Box b2 = new Box(sc.nextInt(), sc.nextInt(), sc.nextInt());
		System.out.println("Box2: "+b2.getBoxDiam());

		System.out.println("The Comparing Both Boxes: ");
		System.out.println(b1.isEqual(b2)?" Same ": " Different");
		sc.close();
	}

}
