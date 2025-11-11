package freddycomapany.ecommerceaplication.Data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

	public List<HashMap<String, String>> getJsonDataToMap(String UrlFile) throws IOException { 
		File fls = new File(UrlFile);
		String file = FileUtils.readFileToString(fls, StandardCharsets.UTF_8);
		//OR FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//java//freddycomapany//ecommerceaplication//TestsComponents"), StandardCharsets.UTF_8)
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(file, new TypeReference<List<HashMap<String, String>>>(){});
	
		return data;
	}

}
