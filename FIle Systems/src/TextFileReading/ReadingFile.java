package TextFileReading;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadingFile {
	public static void main(String[] args) {
		File file = new File("NewFile.txt");
		ArrayList<String> listOfLines = new ArrayList<>();

		try {
			Scanner fileReader = new Scanner(file);

			while (fileReader.hasNext()) {
				String data = fileReader.nextLine();
				listOfLines.add(data);

				break;
			}
			System.out.println(listOfLines);
			fileReader.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

}
