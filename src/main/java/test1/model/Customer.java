package test1.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Customers")
public class Customer {
	
	@Id
	private String _id;
	private String firstName;
	private String lastName;
	private String address;
	private String phone;
	
	/*public Customer(String string, String string2, String string3,
			String string4, String string5) {
		this._id = string;
		this.firstName = string2;
		this.lastName = string3;
		this.address = string4;
		this.phone = string5;
	}*/
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	

}
