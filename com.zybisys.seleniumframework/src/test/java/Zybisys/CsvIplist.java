package Zybisys;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class CsvIplist {
	
	private static final String IPV4_REGEX = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\."
			+ "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." + "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\."
			+ "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

	private static final Pattern IPv4_PATTERN = Pattern.compile(IPV4_REGEX);

	public static boolean isValidInet4Address(String ip) {
		if (ip == null) {
			return false;
		}

		Matcher matcher = IPv4_PATTERN.matcher(ip);

		return matcher.matches();
	
}
	
	@Test
	public void add() throws EncryptedDocumentException, InterruptedException, IOException {
		
	
	
	
	ArrayList<CoCDashboard> csvIPList = new ArrayList<>();
	csvIPList =CsvIplist.getIPListFromCSV("./src/test/resources/CommonData/Vm dc2 -Testing.xlsx");
	for (int i = 0; i < csvIPList.size(); i++) {
		//System.out.println(csvIPList.get(i).IP + " - CPU "+ csvIPList.get(i).Capacity_CPU + " - RAM"+ csvIPList.get(i).Capacity_RAM + " - HDD " + csvIPList.get(i).Capacity_HDD );
	      System.out.println(csvIPList.get(i).IP);
	}

}
	
	public static ArrayList<CoCDashboard> getIPListFromCSV(String filename)
			throws InterruptedException, EncryptedDocumentException, IOException {

		ArrayList<String> arraylist = new ArrayList<>();
		ArrayList<CoCDashboard> myArraylist = new ArrayList<>();

		FileInputStream fis = new FileInputStream(filename);
		Workbook book = WorkbookFactory.create(fis);

		Sheet sh = book.getSheet("Sheet1");
		int lastrow = sh.getLastRowNum();
		return myArraylist;
}
}
