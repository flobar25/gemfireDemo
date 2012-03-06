package com.arvatosystems.dto;

import com.gemstone.gemfire.pdx.PdxReader;
import com.gemstone.gemfire.pdx.PdxSerializable;
import com.gemstone.gemfire.pdx.PdxWriter;

public class UserDTO implements PdxSerializable{
	private String firstName;
	private String lastName;
	private String email;
	
	public UserDTO(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(getFirstName()).append("/").append(getLastName()).append("/").append(getEmail());
		return sb.toString();
	}


	@Override
	public void fromData(PdxReader reader) {
		 email = reader.readString("email");
		 email = reader.readString("firstName");
		 email = reader.readString("lastName");
	}


	@Override
	public void toData(PdxWriter writer) {
		writer.writeString("email", email);
		writer.writeString("firstName", firstName);
		writer.writeString("lastName", lastName);
	}
	
}
