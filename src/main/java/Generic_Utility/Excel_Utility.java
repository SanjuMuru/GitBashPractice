package Generic_Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {

	/**
	 * Reading Single data from Excel
	 * 
	 * @param sheetName
	 * @param RowNum
	 * @param CellNum
	 * @return
	 * @throws Throwable
	 */
	public String getExcelData(String sheetName, int RowNum, int CellNum) throws Throwable {
		// Step1:- Path Connection of the physical File
		FileInputStream fes = new FileInputStream("./src/test/resources/Vtiger.xlsx");

		// step2:- keep Excel_File in Read mode
		Workbook book = WorkbookFactory.create(fes);

		// step3:- get control of the sheet
		Sheet sheet = book.getSheet(sheetName);

		// step4:- get control of the Row
		Row row = sheet.getRow(RowNum);

		// step5:- get control of the Cell
		Cell cell = row.getCell(CellNum);

		String ExcelData = cell.getStringCellValue();
		return ExcelData;

	}

	/**
	 * Reading Single data from Excel Using DataFormatter
	 * 
	 * @param sheetName
	 * @param RowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	public String getExcelDataUsingDataFormatter(String sheetName, int RowNum, int cellNum) throws Throwable {
		// Step1:- Path Connection of the physical File
		FileInputStream fis = new FileInputStream("./src/test/resources/Vtiger.xlsx");

		// step2:- keep Excel_File in Read mode
		Workbook book = WorkbookFactory.create(fis);

		// step3:- get control of the sheet
		Sheet sheet = book.getSheet(sheetName);

		// step4:- get control of the Row
		Row row = sheet.getRow(RowNum);

		// step5:- get control of the Cell
		Cell cell = row.getCell(cellNum);

		DataFormatter format = new DataFormatter();
		String excelData = format.formatCellValue(cell);
//			             System.out.println(excelData);
		return excelData;
	}

	public Object[][] readDataUsingDataProvider(String SheetName) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/Vtiger.xlsx");

		// step2:- keep Excel_File in Read mode
		Workbook book = WorkbookFactory.create(fis);

		// step3:- get control of the sheet
		Sheet sheet = book.getSheet(SheetName);
		int lastRow = sheet.getLastRowNum() + 1;
		short lastCell = sheet.getRow(0).getLastCellNum();

		Object[][] objArr = new Object[lastRow][lastCell];

		for (int i = 0; i < lastRow; i++) {
			for (int j = 0; j < lastCell; j++) {
				objArr[i][j] = sheet.getRow(i).getCell(j).toString();
			}
		}

		return objArr;

	}

}
