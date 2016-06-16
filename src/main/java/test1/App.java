package test1;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import test1.model.Customer;


@SpringBootApplication
public class App {
	public static void main(String[] args)
	{
		SpringApplication.run(App.class, args);
		/*RestTemplate rt = new RestTemplate();
		String url = "http://localhost:8080/customer";
		
		// GET REQUEST
		String url1 = "http://localhost:8080/customer?id=01";
		Customer cs1 = rt.getForObject(url1, Customer.class);
		System.out.println("object received with id 01 "+cs1);
		
		// POST REQUEST
		JSONObject param = new JSONObject();
		param.put("_id", "11");
		param.put("firstName", "Rajat");
		param.put("lastName", "Tulasyan");
		param.put("address", "Sushant Lok");
		param.put("phone", "8882379404");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(param.toString(), headers);
		System.out.println(rt.exchange(url,HttpMethod.POST, entity, String.class));
		
		// DELETE REQUEST
		System.out.println(rt.exchange(url1,HttpMethod.DELETE, entity, String.class));
		
		// PUT REQUEST
		JSONObject param1 = new JSONObject();
		param1.put("_id", "11");
		param1.put("firstName", "Rajat");
		param1.put("lastName", "Tulasyan");
		param1.put("address", "Sushant Lok");
		param1.put("phone", "88823794033");		
		HttpEntity<String> entity1 = new HttpEntity<String>(param1.toString(), headers);
		System.out.println(rt.exchange(url,HttpMethod.PUT, entity1, String.class));*/
		
		
	}
}