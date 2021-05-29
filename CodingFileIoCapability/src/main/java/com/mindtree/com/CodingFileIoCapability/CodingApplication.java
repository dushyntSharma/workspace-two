package com.mindtree.com.CodingFileIoCapability;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CodingApplication {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException {
		boolean flag = true;
		int choice = 0;
		do {
			displayMenu();
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				readExcel();
				break;

			case 2:
				System.out.println("Enter the Team");
				String team = sc.next();
				readExcelFile(team);
				break;

			case 3:
				System.out.println("Enter the Team");
				String team1 = sc.next();
				System.out.println("Enter you updated cost");
				int cost = sc.nextInt();
				updateCost(team1, cost);
				break;

			case 4:
				System.out.println("Enter the team");
				String team3 = sc.next();
				addIPL(team3);
				break;
			default:
				System.out.println("Invalid choice!!");
				break;
			}

		} while (flag);

	}

	public static void readExcel() throws FileNotFoundException {
		File file2 = new File("coding.txt");
		Writer fw = null;
		try {
			fw = new FileWriter(file2);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			FileInputStream file = new FileInputStream(
					"C:/Users/SHREEVATSA/Desktop/Eclipse Workplace - 1/CodingFileIoCapability/Shreevasta.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);

			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					int id, cost;
					String team;
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						System.out.print(cell.getNumericCellValue() + "\t");
						fw.write(String.valueOf(cell.getNumericCellValue()));
						break;
					case Cell.CELL_TYPE_STRING:
						System.out.print(cell.getStringCellValue() + "\t");
						fw.write(String.valueOf(cell.getStringCellValue()));
						break;
					}
					fw.write("     ");
					System.out.print("   ");

				}
				fw.write("\n");
				System.out.println("\n");

			}
			fw.write("\n");

			file.close();
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private static void readExcelFile(String string) {
		try {
			File file = new File(
					"C:/Users/SHREEVATSA/Desktop/Eclipse Workplace - 1/CodingFileIoCapability/Shreevasta.xlsx");
			FileInputStream fis = new FileInputStream(file);

			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0);

			Iterator<Row> itr = sheet.iterator();

			while (itr.hasNext()) {
				Row row = itr.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				boolean flag = false;
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING:

						if (cell.getStringCellValue().equalsIgnoreCase(string)) {
							flag = true;
						} else {
							continue;
						}

						break;
					case Cell.CELL_TYPE_NUMERIC:
						if (flag) {
							System.out.print("Cost: " + cell.getNumericCellValue());
							flag = false;
						} else {

						}

						break;
					default:
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void updateCost(String string, int cost) {
		FileInputStream fis = null;
		Workbook workbook = null;
		try {
			fis = new FileInputStream("Shreevasta.xlsx");
			workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rows = sheet.iterator();
			rows.next();
			while (rows.hasNext()) {
				Row row = rows.next();
				if (row.getCell(1).getStringCellValue().equalsIgnoreCase(string)) {
					Cell cell = row.getCell(2);
					cell.setCellValue(cost);
				}

			}
			workbook.write(new FileOutputStream("Shreevasta.xlsx"));
			workbook.close();
			System.out.println("Cost is updated");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {

				}
				if (workbook != null) {
					workbook.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	private static void addIPL(String string) {
		FileInputStream fis = null;
		Workbook workbook = null;
		try {
			fis = new FileInputStream("Shreevasta.xlsx");
			workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rows = sheet.iterator();
			rows.next();
			while (rows.hasNext()) {
				Row row = rows.next();
				if (row.getCell(1).getStringCellValue().equalsIgnoreCase(string)) {
					Cell cell = row.getCell(1);
					cell.setCellValue(string + " IPL");
				}

			}
			workbook.write(new FileOutputStream("Shreevasta.xlsx"));
			workbook.close();
			System.out.println("updated");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {

				}
				if (workbook != null) {
					workbook.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	private static void displayMenu() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("1.Read Excel data");
		System.out.println("2.Search team");
		System.out.println("3.Update the cost");
		System.out.println("4.Add IPL to the team");

	}
}
