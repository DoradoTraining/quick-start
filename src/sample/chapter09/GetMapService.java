package sample.chapter09;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bstek.dorado.annotation.DataProvider;

@Service
public class GetMapService {
	
	@DataProvider
	public Map<String, String> getMapping(){
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("Mr.", "Mister");
		map.put("Mrs.", "Mistress");
		map.put("Ms.", "Miss");
		map.put("Dr.", "Doctor");
		return map;
	}

}
