package guru.desenvolvedor.wbindex.resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import guru.desenvolvedor.wbindex.model.Countries;



@Path("/pais")
public class PaisResource {
	
	private static final String URL_PAISES="http://api.worldbank.org/v2/country";
	
	private Countries getPaisesFromWb()  {
		URL url;
		try {
			url = new URL(URL_PAISES);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setConnectTimeout(900);
			con.setReadTimeout(900);
			int status = con.getResponseCode();
			BufferedReader in = new BufferedReader(
					  new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
			    content.append(inputLine);
			}
			in.close();
			XmlMapper xmlMapper = new XmlMapper();
			xmlMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			Countries countries = xmlMapper.readValue(content.toString(), Countries.class);
			return countries;

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getPaises() {
		ObjectMapper Obj = new ObjectMapper();
		String jsonStr = "";
		try {
			Countries saida = this.getPaisesFromWb();
			jsonStr = Obj.writeValueAsString(saida);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return jsonStr;
	}
	
	
}
