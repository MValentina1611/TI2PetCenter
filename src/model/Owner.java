package model;

public class Owner{

	//Attributes:
	private String idOwner;//Inputs. Owner's id
	private String fullName;//Inputs. Owner's fullname
	private String phone;//Inputs. Owner's phone
	private String address;//Inputs. Owner's address

	
	//Builder:

	/**
	* Creates owners <br>
	* <b> pre:</b> the attributes must be declared<br>
	* <b> pos:</b> The attributes are initialized<br>
	* @param atrributes types must match
	*/

	public Owner( String idOwner, String fullName, String phone, String address )
	{
		this.idOwner = idOwner;
		this.fullName = fullName;
		this.phone = phone;
		this.address = address;

	}

	//getters:

	public String getFullName()
	{
		return fullName;
	}

	//toString method:

	public String toString()
	{
		String ownerInfo = "";
		
		ownerInfo = "\n\tOwner's Data:\n\tId: "+idOwner+ "\n\tName: "+fullName+"\n\tPhone: "+phone+"\n\tAddress: "+address;

		return ownerInfo;
	}

}

