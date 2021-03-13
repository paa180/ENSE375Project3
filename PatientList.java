package com.uregina.app;
import com.uregina.exception.*;
import java.util.ArrayList;

public class PatientList 
{
	private ArrayList<Patient> patientList;
    	public PatientList() 
    	{
			this.patientList = new ArrayList<Patient>();
    	}
    	/**
	*
	* @return boolean: true if the patient can be added to the list 
	*/
    	public boolean addPatient(Patient patient)
    	{
			this.patientList.add(patient);

    		return true;
    	}
    	/**
	*
	* @return boolean: true if the patient is removed from the list 
	*/
    	public boolean deletePatient(int index)
    	{
			this.patientList.remove(index);

    		return true;
    	}
    	public Patient getPatient(String ID)
    	{
			Patient returnPatient = null;

			for(Patient patient : this.patientList) {
				if(patient.getID().equals(ID))
					returnPatient = patient;
			}

    		return returnPatient;
    	}
    	public int getNumberofPatients()
    	{
    		//ToDo: add you code here (you can update the return statement)
    		return this.patientList.size();
    	}
}
