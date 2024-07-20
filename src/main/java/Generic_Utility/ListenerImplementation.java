package Generic_Utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener {

	@Override // righclick-->source-->override method
	
	public void onTestFailure(ITestResult result) {

		Java_Utility jis = new Java_Utility();
		int ranNum = jis.getRandomNum();

		TakesScreenshot ts = (TakesScreenshot) BaseClass.sDriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/failedScript" + ranNum + ".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
