package com.uregina.app;
import com.uregina.exception.*;

import java.util.ArrayList;

public class PatientHistogram 
{
	private int[][] patientCount;
    	public PatientHistogram() 
    	{
			this.patientCount = new int [20][10];
    	}
    	/**
	*
	* @return boolean: true if the a patient can be added from that region 
	*/
    	public boolean addAPatientToRegion(int VIndex,int HIndex)
    	{
    		try{
				this.patientCount[VIndex][HIndex] += 1;
				return true;
    		}
    		catch(Exception e) {
    			return false;
    		}
    	}
	/**
	*
	* @return boolean: true if the a patient can be removed from that region 
	*/
    	public boolean deleteAPatientFromRegion(int VIndex,int HIndex)
    	{
    		try {
				if (this.patientCount[VIndex][HIndex] != 0) {
					this.patientCount[VIndex][HIndex] -= 1;
					return true;
				}
				else
					return false;
    		}
    		catch(Exception e) {
    			return false;
    		}
    	}
    	public int getPatientsCountInRegion(int VIndex,int HIndex) throws IndexOutOfBoundsException
    	{
    		try {
    			return this.patientCount[VIndex][HIndex];
    		}
    		catch(Exception e) {
    			return -1;
    		}
    	}
}
