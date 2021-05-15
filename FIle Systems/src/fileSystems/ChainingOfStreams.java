package fileSystems;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class ChainingOfStreams {
	public static void main(String argv[]) {
		try {
			File file = new File("ChainOfStreams.txt");
			FileOutputStream fos = new FileOutputStream(file);
			OutputStreamWriter out = new OutputStreamWriter(fos);
			out.write("This text is written using the Chain of different Streams");
			System.out.println("The Text has been Successfuly written");
			out.close();
		} catch (Exception e) {
		}
	}

}
