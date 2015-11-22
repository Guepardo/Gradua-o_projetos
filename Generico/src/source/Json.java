package source;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Json {

	@SuppressWarnings("unchecked")
	public String Encoder ( Transport transport ){
		JSONObject  json = new JSONObject();
		json.put("message",transport.getMessage());
		json.put("type",transport.getType());
		json.put("namePeer", transport.getNamePeer() );
		json.put("userType", transport.getUserType());
		return json.toString();
	};
	
	public Transport Decoder ( String jsonString ){
		JSONParser  parser = new JSONParser();
		JSONObject json = null;
		try {
			 json = (JSONObject) parser.parse(jsonString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//Biulding an transport object.
		Transport temp = new Transport((String) json.get("namePeer"),
									   (String) json.get("message") ,
									   (String) json.get("type"),
									   (String) json.get("userType"));
		return temp;
	}
}
