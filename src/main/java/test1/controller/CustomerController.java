package test1.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import test1.model.Customer;
import test1.model.Deal;
import test1.service.CustomerService;
import test1.util.CommonUtils;

@RestController
public class CustomerController {
	
	private String template = "Customer Added";
	private String postException = "This id exist.";
	private String getException = "This id does not exist.";
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/customer", method=RequestMethod.POST)
	public String create(@RequestBody Customer customer)
	{
		boolean check = customerService.checkCustomer(customer.get_id());
		if(check)
			return String.format(postException);
		else
		{
			customerService.addCustomer(customer);
			return String.format(template);
		}			
	}
	
	@RequestMapping(value="/customer", method=RequestMethod.GET)
	public Customer find(@RequestParam(value="id", defaultValue="00")String id)
	{
		boolean check = customerService.checkCustomer(id);
		if(check)
			return customerService.getCustomer(id);
		return null;
	}
	
	@RequestMapping(value="/customer", method=RequestMethod.PUT)
	public String update(@RequestBody Customer customer){								 
		boolean check = customerService.checkCustomer(customer.get_id());					
		if(check==false){
			return String.format(getException);
		}else{
			customerService.updateCustomer(customer);										
			return String.format("Entity Updated");
		}
	}
	
	@RequestMapping(value="/customer", method=RequestMethod.DELETE)
	public String delete(@RequestParam(value="id", defaultValue="00") String id){
		boolean check = customerService.checkCustomer(id);								
		if(check == false){
			return String.format("id does not exist");
		}else{
			customerService.deleteCustomer(id);											
			return String.format("Entity Deleted");
		}
	}
	
	@RequestMapping(value="/deal", method=RequestMethod.POST)
	public String createDeal(@RequestBody Deal deal)
	{
		String deal1 = CommonUtils.toJson(deal);
		RestTemplate rt = new RestTemplate();
		String url = "http://localhost:8080/create";
		/*JSONObject param = new JSONObject();
		param.put("_id", "11");
		param.put("type", "Buy One Get One");
		param.put("discount", "50%");
		param.put("merchantName", "Subway");
		param.put("name", "Buy one Sub, get one free..");*/
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(deal1, headers);
		return rt.exchange(url,HttpMethod.POST, entity, String.class).toString();
	}
	
	@RequestMapping(value="/deal", method=RequestMethod.GET)
	public Deal findDeal(@RequestParam(value="id", defaultValue="00")String id)
	{
		RestTemplate rt = new RestTemplate();
		String url1 = "http://localhost:8080/find?id="+id;
		return rt.getForObject(url1, Deal.class);
	}
	
	@RequestMapping(value="/deal", method=RequestMethod.PUT)
	public String updateDeal(@RequestBody Deal deal){								 
		RestTemplate rt = new RestTemplate();
		String url = "http://localhost:8080/update";
		String deal1 = CommonUtils.toJson(deal);
		/*JSONObject param1 = new JSONObject();
		param1.put("_id", "11");
		param1.put("firstName", "Rajat");
		param1.put("lastName", "Tulasyan");
		param1.put("address", "Sushant Lok");
		param1.put("phone", "88823794033");	*/
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity1 = new HttpEntity<String>(deal1, headers);
		return rt.exchange(url,HttpMethod.PUT, entity1, String.class).toString();
	}
	
	@RequestMapping(value="/deal", method=RequestMethod.DELETE)
	public String deleteDeal(@RequestParam(value="id", defaultValue="00") String id){
		
		RestTemplate rt = new RestTemplate();
		String url = "http://localhost:8080/delete?id="+id;
		JSONObject param1 = new JSONObject();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(param1.toString(), headers);
		return rt.exchange(url,HttpMethod.DELETE, entity, String.class).toString();
	}
	
	
	
	

}
