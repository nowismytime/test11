package test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tes1.vo.DealVO;
import test1.model.Customer;
import test1.model.Deal;
import test1.repository.DealRepository;


@Service
public class DealService{
	
	//private DealVo deal = new DealVo();
	
	@Autowired
	private DealRepository dealRepository;		//because of this we can access functions of DealRepository without creating a new object
	
	public boolean CheckDeal(String id){
		return dealRepository.exists(id);		//checks for existence 
	}
	
	public void CreateDeal(Deal deal){
		dealRepository.save(deal);				//adding deal in database
		//return new DealVO(deal);
	}
	
	public DealVO ErrorDeal(String id){
		Deal deal = new Deal();
		deal.set_id("ID does not exists");		
		deal.setName("ID does not exists");
		return new DealVO(deal);				//return object whose id is does not exist to imply non existence of deal
	}
	
	public DealVO FindDeal(String id){
		Deal deal = dealRepository.findOne(id); //retrieves deal of that specific id
		return new DealVO(deal);
	}
	
	public void UpdateDeal(Deal deal){
		dealRepository.save(deal);				//saves deal in database
	}
	
	public void DeleteDeal(String id){
		dealRepository.delete(id);				//deletes deal
	}
	
	public Deal getDeal(String id)
	{
		return dealRepository.findOne(id);
	}
}















/*public DealVO CreateDeal(Deal deal){
dealRepository.save(deal);
return new DealVO(deal);
}*/

/*	public DealVO CreateDeal(String id, String name, String merchantName, String type, String discount){
Deal deal = new Deal();
deal.set_id(id);
deal.setName(name);
deal.setMerchantName(merchantName);
deal.setType(type);
deal.setDiscount(discount);

dealRepository.save(deal);

return new DealVO(deal);
} */
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nearbuy.firstproject.db.model.Deal;
import com.nearbuy.firstproject.db.repository.DealRepository;
import com.nearbuy.firstproject.vo.DealVO;


@Service
public class DealService {

	@Autowired
	private DealRepository dealRepo;
	
	public DealVO createDeal(String id) {
		
		//creating new deal object for the passed id
		Deal deal = new Deal();
		deal.set_id(id);
		deal.setDiscount("10");
		deal.setMerchantName("merchantName");
		deal.setName("name");
		dealRepo.save(deal);
		
		return new DealVO(deal);
		
	}
	
}
*/