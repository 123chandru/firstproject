package APITest.Api_Testing;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Sample {
	
	@Test(dataProvider = "GetName")
	public void getData(String name, String id)
	{
		System.out.println(name+"and id is:"+id);
	}
	
	
	@DataProvider()
	public Object GetName()
	{
		Object [][] a = 
			{
					{"Arun","1234"},
					{"Venkatesh", "12345"},
			};
		return a;
	}

}
