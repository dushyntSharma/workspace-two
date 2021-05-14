package fileSystems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadingFile {
	public static void main(String[] args) throws IOException {
		BufferedReader bufReader = new BufferedReader(
				new FileReader("C:\\Users\\SHREEVATSA\\Desktop\\Eclipse Workplace - 1\\FIle Systems\\readingfile.txt"));
		ArrayList<String> listOfLines = new ArrayList<>();

		String line = null;
		try {
			line = bufReader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (line != null) {
			listOfLines.add(line);
			line = bufReader.readLine();
		}
		System.out.println(listOfLines);

		bufReader.close();

	}

}
