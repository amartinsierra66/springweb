package locator;

import java.util.Arrays;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import model.Pais;
@Component
public class DatosLocator {
	String url="https://restcountries.com/v2/all";
	
	@Autowired
	RestTemplate template;
	public Stream<Pais> streamPaises(){	
		return Arrays.stream(template.getForObject(url, Pais[].class));
	}
}
