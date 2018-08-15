package test.utilities;

import java.io.*;
import java.util.*;
import java.text.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import org.testng.*;
import test.utilities.Driver;

public class ScreenshotListener extends TestListenerAdapter {
	
	Driver driver = new Driver();
	
    @Override
    public void onTestFailure(ITestResult result) {
    	
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        String methodName = result.getName();
        if(!result.isSuccess()){
            File scrFile = ((TakesScreenshot)driver.getDriver()).getScreenshotAs(OutputType.FILE);
            
            try {
                String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/test-output";
                File destFile = new File((String) reportDirectory+"/failure_screenshots/"+methodName+"_"+formater.format(calendar.getTime())+".png");
                System.out.println(destFile.getAbsoluteFile());
                
                FileUtils.copyFile(scrFile, destFile);
                Reporter.log("<a href='"+ destFile.getAbsolutePath() + "'> <img src='"+ destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}