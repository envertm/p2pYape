package collection.helpers;

import collection.utility.ExcelReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class Hook  {
	
    private static String FILE1 = "data.xlsx";
    private static String SHEET1 = "Casos Prueba";
	
    protected static List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(FILE1, SHEET1);
    }
	
}
