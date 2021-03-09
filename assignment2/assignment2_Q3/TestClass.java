package assignment2_Q3;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestClass {
	public static void main(String[] args) {
		String path = "C:\\Users\\bharat.gupta_metacub\\Downloads\\CollegeData.xlsx";
			try {
				File file = new File(path);
				FileInputStream fileInputStream = new FileInputStream(file);
				XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
				XSSFSheet sheet = workbook.getSheet("Course List");


				int totalRows = sheet.getPhysicalNumberOfRows();


				for (int row = 1; row < totalRows; row++) {
					XSSFRow currentRow = sheet.getRow(row);
					int cellNum = currentRow.getPhysicalNumberOfCells();


					for (int cell = 1; cell < cellNum; cell++) {
						XSSFCell currentCell = currentRow.getCell(cell);
						System.out.print(row + " " +currentCell.getNumericCellValue()+ " ");
					}
					System.out.println();

				}
				workbook.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
}
