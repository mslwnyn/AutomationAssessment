package za.co.ilab.tshimx.utils;

/**
 *
 * @author Tshimologo
 */
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.InputStream;

public class DataUtil {
    
      public  XSSFWorkbook workbook;
      public  XSSFSheet sheet;
      public  XSSFRow row;
      public  XSSFCell cell;

      public DataUtil(InputStream input, String sheetName ){
            try {
                  workbook = new XSSFWorkbook(input) ;
            }catch(Exception e){
                  sheet=workbook.getSheet(sheetName);
                  e.printStackTrace();
            }
      }

      public  int getRowCount ( )throws Exception  {

            int rowNum= sheet.getLastRowNum();
            workbook.close();
            System.out.println("Number of Rows: "+rowNum);
            return rowNum;

      }

      public  int getColumnCount ( int num)throws Exception  {
            row = sheet.getRow(num);
            int colNum= row.getLastCellNum();
            System.out.println("Number of Columns: "+ colNum );
            return colNum;
      }

    
}
