package test;

public class Loops {
	public static void main(String[] args) {
		int i, j, k, num = 0;
//		for (i = 0; i < 5; i++) // outer loop for rows
//		{
//			num = 1;
//			for (j = 0; j <= i; j++) // inner loop for rows
//			{
//				// printing num with a space
//				System.out.print(num + " ");
//
//				// incrementing value of num
//				num++;
//			}
//
//			// ending line after each row
//			System.out.println();
//		}

		for (i = 1; i <= 5; i++) {
			int p = 1;
			for (j = i; j <= 5; j++) {
				System.out.print(p++ + " ");
			}
			System.out.println();

		}

		for (i = 1, k = 1; i <= 5; i++, k++) {
			int p = k;
			for (j = i; j <= 5; j++) {
				System.out.print(p++ + " ");
			}
			System.out.println();

		}

		for (i = 1; i <= 5; i++) {
			int p = 5;
			for (j = 1; j <= i; j++) {
				System.out.print(" ");
			}
			for (j = i; j <= 5; j++) {
				System.out.print(p-- + "");
			}
			System.out.println();

		}

		for (i = 1, k = 5; i <= 5; i++, k--) {
			int p = k;

			for (j = i; j <= 5; j++) {
				System.out.print(p-- + " ");
			}
			System.out.println();

		}

	}

}
