package TextFileReading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class UsingBuffered {
	public static void main(String[] args) throws IOException {
		BufferedReader bufReader = new BufferedReader(new FileReader("NewFile.txt"));
		ArrayList<String> listOfLines = new ArrayList<>();

		String line;
		try {
			line = bufReader.readLine();
			while (line != null) {
				listOfLines.add(line);
				line = bufReader.readLine();

			}
			System.out.println(listOfLines);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bufReader.close();

	}

}
