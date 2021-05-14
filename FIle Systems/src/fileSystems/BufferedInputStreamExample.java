package fileSystems;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedInputStreamExample {
	public static void main(String args[]) throws IOException {
		// Creating an BufferedInputStream object
		BufferedInputStream inputStream = new BufferedInputStream(System.in);
		byte bytes[] = new byte[1024];
		System.out.println("Enter your data ");
		// Reading data from key-board
		inputStream.read(bytes);
		// Creating BufferedOutputStream object
		FileOutputStream out = new FileOutputStream("D:/myFile.txt");
		BufferedOutputStream outputStream = new BufferedOutputStream(out);
		// Writing data to the file
		outputStream.write(bytes);
		outputStream.flush();
		System.out.println("Data successfully written in the specified file");
	}

}
