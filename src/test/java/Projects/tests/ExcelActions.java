package Projects.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelActions {

	
	public ArrayList<String> getExcelData(String testcaseName) throws IOException {

		// TODO Auto-generated method stub
		
		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("D:\\Workspace\\demodata.xlsx");
		XSSFWorkbook wrkbk = new XSSFWorkbook(fis);
		
		int sheets = wrkbk.getNumberOfSheets();

		for(int i=0;i<sheets; i++)
		{
			if (wrkbk.getSheetName(i).equalsIgnoreCase("testdata"))
			{	
				XSSFSheet sheet =wrkbk.getSheetAt(i);
				
				Iterator<Row> row = sheet.iterator();
				Row firstrow= row.next();
				
				Iterator<Cell> cell = firstrow.iterator();
				int k=0;
				int coloumn = 0;
				while(cell.hasNext()) {
					Cell value = cell.next();
					
					if(value.getStringCellValue().equalsIgnoreCase(testcaseName)){
						coloumn=k;
					}
					k++;
				}
				System.out.println(coloumn);
				
				//once coloumn identified iterate through rows to go and grab the data from the row which we need
				while(row.hasNext()) {
					Row r = row.next();
					
					if(r.getCell(coloumn).getStringCellValue().equalsIgnoreCase("purchase")) {
						Iterator<Cell> cv = r.cellIterator();
						
						while(cv.hasNext()) {
							a.add((cv.next().getStringCellValue()));
						}
					}
					
				}
			}
		}
		return a;
		
		
	
	}
	public static void main(String[] args) throws IOException {}

}
