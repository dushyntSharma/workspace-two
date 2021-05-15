package TextFileReading;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadingFile {
	public static void main(String[] args) {
		File file = new File("NewFile.txt");

		try {
			Scanner fileReader = new Scanner(file);

			while (fileReader.hasNext()) {
				String data = fileReader.nextLine();
				System.out.println(data);
				break;
			}
			fileReader.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}
}
