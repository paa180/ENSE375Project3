package com.uregina.app;

import static org.junit.Assert.assertTrue;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import jdk.jfr.Timestamp;
import java.util.ArrayList;
import com.uregina.exception.*;

/**
 * Unit test for RiskCodeMap.
 */
public class RiskCodeMapTest 
{
    @Test
    public void riskIsNull() {
        RiskCodeMap map =  new RiskCodeMap();
        int VIndex = 1, HIndex = 1;

        assertEquals(map.getRiskInARegion(VIndex, HIndex), "");
    }

    @Test
    public void riskIsGreen() {
        RiskCodeMap map =  new RiskCodeMap();
        PatientHistogram histogram = new PatientHistogram();
        int VIndex = 1, HIndex = 1;

        histogram.addAPatientToRegion(VIndex,HIndex);

        ArrayList<Integer> neighboursCaseCount= new ArrayList<Integer> ();
        for (int i=-1;i<=1;i+=2){
    		neighboursCaseCount.add(histogram.getPatientsCountInRegion(VIndex+i,HIndex));
    	}
    	for (int i=-1;i<=1;i+=2){
    		neighboursCaseCount.add(histogram.getPatientsCountInRegion(VIndex,HIndex+i));
    	}
        
        map.updateRiskInARegion(VIndex,HIndex,histogram.getPatientsCountInRegion(VIndex, HIndex),neighboursCaseCount);

        assertEquals(map.getRiskInARegion(VIndex, HIndex), 'G');
    }

    @Test
    public void riskIsBlue() {
        RiskCodeMap map =  new RiskCodeMap();
        PatientHistogram histogram = new PatientHistogram();
        int VIndex = 1, HIndex = 1;

        histogram.addAPatientToRegion(VIndex,HIndex);

        ArrayList<Integer> neighboursCaseCount= new ArrayList<Integer> ();
        for (int i=-1;i<=1;i+=2){
    		neighboursCaseCount.add(histogram.getPatientsCountInRegion(VIndex+i,HIndex));
    	}
    	for (int i=-1;i<=1;i+=2){
    		neighboursCaseCount.add(histogram.getPatientsCountInRegion(VIndex,HIndex+i));
    	}
        
        map.updateRiskInARegion(VIndex,HIndex,histogram.getPatientsCountInRegion(VIndex, HIndex),neighboursCaseCount);

        assertEquals(map.getRiskInARegion(VIndex, HIndex), 'B');
    }

    @Test
    public void riskIsYellow() {
        RiskCodeMap map =  new RiskCodeMap();
        PatientHistogram histogram = new PatientHistogram();
        int VIndex = 1, HIndex = 1;

        for(int i = 0; i < 5; i++) {
            histogram.addAPatientToRegion(VIndex,HIndex);
        }

        ArrayList<Integer> neighboursCaseCount= new ArrayList<Integer> ();
        for (int i=-1;i<=1;i+=2){
    		neighboursCaseCount.add(histogram.getPatientsCountInRegion(VIndex+i,HIndex));
    	}
    	for (int i=-1;i<=1;i+=2){
    		neighboursCaseCount.add(histogram.getPatientsCountInRegion(VIndex,HIndex+i));
    	}
        
        map.updateRiskInARegion(VIndex,HIndex,histogram.getPatientsCountInRegion(VIndex, HIndex),neighboursCaseCount);

        assertEquals(map.getRiskInARegion(VIndex, HIndex), 'Y');
    }

    @Test
    public void riskIsOrange() {
        RiskCodeMap map =  new RiskCodeMap();
        PatientHistogram histogram = new PatientHistogram();
        int VIndex = 1, HIndex = 1;

        for(int i = 0; i < 9; i++) {
            histogram.addAPatientToRegion(VIndex,HIndex);
        }

        ArrayList<Integer> neighboursCaseCount= new ArrayList<Integer> ();
        for (int i=-1;i<=1;i+=2){
    		neighboursCaseCount.add(histogram.getPatientsCountInRegion(VIndex+i,HIndex));
    	}
    	for (int i=-1;i<=1;i+=2){
    		neighboursCaseCount.add(histogram.getPatientsCountInRegion(VIndex,HIndex+i));
    	}
        
        map.updateRiskInARegion(VIndex,HIndex,histogram.getPatientsCountInRegion(VIndex, HIndex),neighboursCaseCount);

        assertEquals(map.getRiskInARegion(VIndex, HIndex), 'O');
    }

    @Test
    public void riskIsRed() {
        RiskCodeMap map =  new RiskCodeMap();
        PatientHistogram histogram = new PatientHistogram();
        int VIndex = 1, HIndex = 1;

        for(int i = 0; i < 20; i++) {
            histogram.addAPatientToRegion(VIndex,HIndex);
        }

        ArrayList<Integer> neighboursCaseCount= new ArrayList<Integer> ();
        for (int i=-1;i<=1;i+=2){
    		neighboursCaseCount.add(histogram.getPatientsCountInRegion(VIndex+i,HIndex));
    	}
    	for (int i=-1;i<=1;i+=2){
    		neighboursCaseCount.add(histogram.getPatientsCountInRegion(VIndex,HIndex+i));
    	}
        
        map.updateRiskInARegion(VIndex,HIndex,histogram.getPatientsCountInRegion(VIndex, HIndex),neighboursCaseCount);

        assertEquals(map.getRiskInARegion(VIndex, HIndex), 'R');
    }
}
