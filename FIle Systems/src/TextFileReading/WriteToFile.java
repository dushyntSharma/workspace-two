package TextFileReading;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WriteToFile {
	public static void main(String[] args) {
		try {
			FileWriter file = new FileWriter("FileOne.txt");
			List<String> arrayList = new ArrayList<>(Arrays.asList("Name", "Age", "Salary"));

			file.write(arrayList.toString());
			file.close();

			System.out.println("Successfully written to a file");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
