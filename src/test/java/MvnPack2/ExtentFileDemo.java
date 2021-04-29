package MvnPack2;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFileDemo {

	public static ExtentReports getInstance()
	{
		Date date = new Date();
		String FileNameType = date.toString().replace(" ", "_").replace(":", "_")+".html";
		String reportFilePath = "Reports\\"+FileNameType;
		ExtentReports eReport = new ExtentReports(reportFilePath, true, DisplayOrder.NEWEST_FIRST);
		
		File reportConfigFile = new File("ReportsConfig.xml");
		
		eReport.loadConfig(reportConfigFile);
		
		eReport.addSystemInfo("TestNG version ", "7.0.0").
		addSystemInfo("WebDriver version", "3.2").
		addSystemInfo("Environment", "QA Staging");
		
		return eReport;
		
	}
}
