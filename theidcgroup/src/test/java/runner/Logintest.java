package runner;


import java.util.List;
import org.testng.TestNG;
import org.testng.collections.Lists;

public class Logintest {

	public static void main(String[] args) {
		TestNG testng = new TestNG();
		List<String> suites = Lists.newArrayList();
		suites.add("D:\\Ecllipse\\Ec_test\\theidcgroup\\testng.xml");
		testng.setTestSuites(suites);
		testng.run();

	}

}
