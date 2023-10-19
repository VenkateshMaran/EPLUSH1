package utils;

import java.util.Properties;

public class ConfigLoader {
	private final Properties properties;
	private static ConfigLoader configloader;
	
	private ConfigLoader()
	{
		properties = PropertyUtils.propertyLoader("src/test/resources/properties/config.properties");
	}
	
	public static ConfigLoader getInstance(){
		if(configloader == null)
		{
			configloader = new ConfigLoader();
		}
		
		return configloader;
		
	}
	
	@SuppressWarnings("unused")
	public String getBaseUrlBBW(String market)
	{
		String  initialURL = properties.getProperty("start_BBW");
		String endURL = properties.getProperty("baseUrl_BBW_UAT");
		String prop = initialURL+market+endURL;
		
		if(prop !=null)
			return prop;
		else throw new RuntimeException("property baseUrl is not specified in the stg_config.properties file");
	}

	public String userName() {
		String username = properties.getProperty("username");
		return username;
	}

	public String password() {
		String password = properties.getProperty("password");
		return password;
	}

}
