package basecamp;

public class Loops {
	public static void main(String[] args) {

		int i = 20;

		if (i == 10)
			System.out.println("i is 10\n");

		else if (i == 15)
			System.out.println("i is 15\n");

		else if (i == 20)
			System.out.println("i is 20\n");

		else
			System.out.println("i is not present\n");

		System.out.println("Outside if-else-if");
		System.out.println();

		System.out.println("---------------------");
		System.out.println("While Loop");
		while (i < 40) {
			System.out.println(i);
			i++;
		}

		System.out.println();
		double d = 9.45;
		int z = (int) d;
		System.out.println(d);
		System.out.println(z);

	}
}
