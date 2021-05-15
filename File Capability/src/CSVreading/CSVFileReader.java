package CSVreading;

import java.io.File;
import java.util.Scanner;

public class CSVFileReader {
	public static void main(String[] args) {
		try {
			File file = new File("csvFile.csv");

			Scanner fileReader = new Scanner(file);

			fileReader.useDelimiter(",");
			while (fileReader.hasNext()) {
				System.out.println(fileReader.next());
			}
			fileReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
