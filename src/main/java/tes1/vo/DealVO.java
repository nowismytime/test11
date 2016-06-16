package tes1.vo;

import test1.model.Deal;
import test1.util.CommonUtils;



public class DealVO{
	private final String id;
	private final String content;
	

	
	public DealVO(Deal deal){
		this.id = deal.get_id();
		this.content = CommonUtils.toJson(deal); //converting data into json format
	}
	
	public String getID(){
		return id;
	}
	
	public String getContent(){
		return content;
	}
}




















/*	public DealVO(String id, String content){
this.id=id;
this.content=content;
} */
/*import com.nearbuy.firstproject.db.model.Deal;
import com.nearbuy.firstproject.util.CommonUtils;

public class DealVO {
	private final String id;
	private final String content;
	
	public DealVO(String id, String content ){
		this.id=id;
		this.content=content;
	}
	
	public DealVO(Deal deal) {
		this.id = deal.get_id();
		this.content = CommonUtils.toJson(deal);
	}

	public String getId(){
		return id;
	}
	
	public String getContent(){
		return content;
	}
}*/