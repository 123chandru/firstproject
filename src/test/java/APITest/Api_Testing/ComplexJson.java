package APITest.Api_Testing;

import io.restassured.path.json.JsonPath;

public class ComplexJson {
	
	static int sum = 0;
	
	public static void main(String [] args)
	{
		JsonPath js = new JsonPath(ComplexJson.response());
		int size = js.getInt("courses.size()");
		
		int total = js.getInt("dashboard.purchaseAmount");
				for(int i = 0; i < size ; i++)
				{
					String title = js.get("courses["+i+"].title");
					
					System.out.println(title);
					
					int addprice = js.getInt("courses["+i+"].price");
					int addcopies = js.getInt("courses["+i+"].copies");
					int add = addprice * addcopies;
					sum = sum+add;
					
					if(title.contains("RPA"))
					{
					int copies = js.getInt("courses["+i+"].copies");
						System.out.println("courses copies is:"+copies);
					}
				}
				System.out.println(sum);
				if(total == sum)
				{
					System.out.println("purchase is passed");
				}
	}
	
	public static String response()
	{
		return "{\r\n"
				+ "\r\n"
				+ "\"dashboard\": {\r\n"
				+ "\r\n"
				+ "\"purchaseAmount\": 910,\r\n"
				+ "\r\n"
				+ "\"website\": \"rahulshettyacademy.com\"\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "\"courses\": [\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "\r\n"
				+ "\"price\": 50,\r\n"
				+ "\r\n"
				+ "\"copies\": 6\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "\r\n"
				+ "\"price\": 40,\r\n"
				+ "\r\n"
				+ "\"copies\": 4\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"RPA\",\r\n"
				+ "\r\n"
				+ "\"price\": 45,\r\n"
				+ "\r\n"
				+ "\"copies\": 10\r\n"
				+ "\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "]\r\n"
				+ "\r\n"
				+ "}";
	}

}
