package TextFileReading;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
	public static void main(String[] args) {
		try {
			FileWriter file = new FileWriter("FileOne.txt");

			file.write("Goo morning minds how was the long weekend");
			file.close();

			System.out.println("Successfully written to a file");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
