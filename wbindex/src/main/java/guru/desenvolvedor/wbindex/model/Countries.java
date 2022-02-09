package guru.desenvolvedor.wbindex.model;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;


public class Countries {
	
	@JacksonXmlProperty(localName = "country")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<Country> countries;

	
	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
	
	
}
