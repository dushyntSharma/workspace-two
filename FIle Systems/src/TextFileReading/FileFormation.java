package TextFileReading;

import java.io.File;

public class FileFormation {
	public static void main(String[] args) {
		File file = new File("NewFile.txt");

		if (file.exists()) {
			System.out.println("File Name :" + file.getName());
			System.out.println("Absolute path :" + file.getAbsolutePath());
			System.out.println("Readable :" + file.canRead());
			System.out.println("Writable :" + file.canWrite());
			System.out.println("File Size in bytes :" + file.length());
		} else {
			System.out.println("File does not exist");
		}
	}

}
