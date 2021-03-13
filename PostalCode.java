package com.uregina.app;
import com.uregina.exception.*;

public class PostalCode 
{
	private String postalCode;
    	public static boolean isValidPostalCode(String postalCode )
    	{
			boolean checkPrefix = false,
			 vertIndex = false,
			 horIndex = false,
			 checkDash = false,
			 checkLetter = false,
			 checkDigit = false;

			if(postalCode.substring(0, 2).equals("K1"))
				checkPrefix = true;

			if(postalCode.charAt(2) >= 'A' && postalCode.charAt(2) <= 'T')
				vertIndex = true;
			
			if(Integer.parseInt(postalCode.substring(3, 4)) >= 0 && Integer.parseInt(postalCode.substring(3, 4)) <= 9)
				horIndex = true;

			if(postalCode.substring(4, 5).equals("-"))
				checkDash = true;

			if(postalCode.charAt(5) >= 'A' && postalCode.charAt(5) <= 'Z')
				checkLetter = true;

			if(Integer.parseInt(postalCode.substring(6, 7)) >= 0 && Integer.parseInt(postalCode.substring(6, 7)) <= 9)
				checkDigit = true;


       		return (checkPrefix == true && vertIndex == true && horIndex == true && checkDash == true && checkLetter == true && checkDigit == true);
    	}
    	public PostalCode(String postalCode) throws InvalidPostalCodeException
    	{
			this.postalCode = postalCode;
    	}
    	public int getRegionVerticalIndex()
    	{	
    		return this.postalCode.charAt(2) - 65;
    	}
    	public int getRegionHorizontalIndex()
    	{
    		return Integer.parseInt(this.postalCode.substring(4, 5));
    	}
    	public String getPostalCode()
    	{
    		return this.postalCode;
    	}
}
