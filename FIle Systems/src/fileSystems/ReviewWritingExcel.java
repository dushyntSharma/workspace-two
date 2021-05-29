package fileSystems;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.FileAlreadyExistsException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReviewWritingExcel {
	public static void main(String[] args) throws FileAlreadyExistsException {
		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet sheet = workbook.createSheet("Student Details");

		Map<Integer, Object[]> map = new TreeMap<Integer, Object[]>();
		map.put(1, new Object[] { "ID", "Name", "Address" });
		map.put(2, new Object[] { "100", "Shreevatsa", "Bangalore" });
		map.put(3, new Object[] { "101", "Vignesh", "Sagar" });
		map.put(4, new Object[] { "102", "Alok", "Bangalore" });
		map.put(5, new Object[] { "103", "Sachin", "Pune" });

		Set<Integer> keyset = map.keySet();
		int num = 0;
		for (Integer key : keyset) {
			Row row = sheet.createRow(num++);
			Object[] objArr = map.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Integer) {
					cell.setCellValue((Integer) obj);
				}

			}
		}
		try {
			File file = new File("newuser.xlsx");
			FileOutputStream out = new FileOutputStream(file);
			workbook.write(out);
			out.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
