package test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tes1.vo.DealVO;
import test1.model.Deal;
import test1.service.DealService;



@RestController
public class DealController{
	
	private final String template = "Deal Entity ADDED";
	private final String postException = "This Deal id exists";
	private final String getException = "This deal id does not exists";
	
	
	@Autowired
	private DealService dealService;										   //because of this no need to create new object of DealService
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String deal(@RequestBody Deal deal){					               //method to Create a deal
		boolean check = dealService.CheckDeal(deal.get_id());	               //checking if deal already exists
		if(check == true){
			return String.format(postException);
		}else{
			dealService.CreateDeal(deal);						                //creating deal
			return String.format(template);
		}
	}
	
	@RequestMapping(value="/find", method=RequestMethod.GET)
	public Deal find(@RequestParam(value="id", defaultValue="00") String id){  //method to find a deal
		boolean check =dealService.CheckDeal(id);
		if(check){	
			return dealService.getDeal(id);
		}else{
			return null;									 //finding deal
		}	
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public String update(@RequestBody Deal deal){								 //method for finding deal
		boolean check = dealService.CheckDeal(deal.get_id());					 //checking if deal exists
		if(check==false){
			return String.format(getException);
		}else{
			dealService.UpdateDeal(deal);										//updating deal
			return String.format("Deal Entity Updated");
		}
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.DELETE)
	public String delete(@RequestParam(value="id", defaultValue="00") String id){//method for deleting deal
		boolean check = dealService.CheckDeal(id);								//checking if deal exists
		if(check == false){
			return String.format("Deal id does not exist");
		}else{
			dealService.DeleteDeal(id);											//deleting deal
			return String.format("Deal Entity Deleted");
		}
	}
}















/*@RequestMapping(value="/deal", method = RequestMethod.POST)
public DealVO deal(@RequestBody Deal deal){
	return dealService.CreateDeal(deal);
}
*/
/*@RequestMapping(value="/deal", method = RequestMethod.GET)
public DealVO deal(@RequestParam(value ="id") String id ,
					@RequestParam(value = "name" ,defaultValue="NONE") String name ,
					  @RequestParam(value = "merchantName", defaultValue = "NONE") String merchantName ,
					    @RequestParam(value = "type" , defaultValue = "NONE") String type ,
					      @RequestParam(value = "discount" , defaultValue = "NONE") String discount){
	return dealService.CreateDeal(id ,name, merchantName, type, discount); 
}*/
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nearbuy.firstproject.service.DealService;
import com.nearbuy.firstproject.vo.DealVO;

@RestController
public class DealController {
	
	private final String template = "Deal"+"%s";
	
	@Autowired
	private DealService dealService;
	
	@RequestMapping(value="/deal", method = RequestMethod.GET)
	public DealVO deal(@RequestParam(value="id", defaultValue="provide parameter") String id){
		return dealService.createDeal(id);
	}

}*/
