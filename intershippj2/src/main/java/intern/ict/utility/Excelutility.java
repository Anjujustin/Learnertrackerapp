package intern.ict.utility;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;






public class Excelutility {
	public static XSSFWorkbook excelWbook;
	public static XSSFSheet excelSheet;

	public static String getData(int rowNum,int colNum) throws IOException
	
	 {
		FileInputStream inp = new FileInputStream("C:\\Users\\JUSTIN\\eclipse-workspace\\intershippj2\\src\\main\\resources\\values.xlsx");
		excelWbook = new XSSFWorkbook(inp);
		excelSheet = excelWbook.getSheetAt(0);
		
		XSSFRow currentRow=excelSheet.getRow(rowNum);
		Cell currentCell = currentRow.getCell(colNum);
		if(currentCell== null)
		{
			return "";
		}
		
		DataFormatter formatter = new DataFormatter();
		String strValue = formatter.formatCellValue(currentCell);
		return strValue;
		
	}
	
}
