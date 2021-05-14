package model;

public class Owner{

	private String idOwner;
	private String fullName;
	private String phone;
	private String address;

	
	public Owner( String idOwner, String fullName, String phone, String address )
	{
		this.idOwner = idOwner;
		this.fullName = fullName;
		this.phone = phone;
		this.address = address;

	}

	public String toString()
	{
		String ownerInfo = "";
		
		ownerInfo = "Owner's Data:\nId: "+idOwner+ "\nName: "+fullName+"\nPhone: "+phone+"\nAddress: "+address;

		return ownerInfo;
	}

}

