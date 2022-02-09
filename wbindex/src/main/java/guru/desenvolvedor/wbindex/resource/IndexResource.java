package guru.desenvolvedor.wbindex.resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.jboss.logging.Logger;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import guru.desenvolvedor.wbindex.model.Countries;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

@Path("index")
public class IndexResource {
	
	private static final Logger LOG = Logger.getLogger(IndexResource.class);
	
	private static final String URL_INDEXES="http://api.worldbank.org/v2/country/@/indicator/SI.POV.DDAY?format=json";
	
	private JsonArray getIndexes(String countryCode) {
		URL url;
		try {
			url = new URL(URL_INDEXES.replace("@",countryCode));
			LOG.info("@@@@@ " + countryCode);
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
			JsonArray objSaida = new JsonArray(content.toString());
			LOG.info("%%% " + objSaida.toString());
			return objSaida;

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
		
	}
	
	@Path("{countryCode}")
	@GET
	public Response getIndexValue(@PathParam("countryCode") String countryCode) {
		LOG.info("$$$ " + countryCode);
		String entity = this.getIndexes(countryCode).toString();
		
		return Response.ok(entity).build();
	}

}
