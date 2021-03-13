package com.uregina.app;
import com.uregina.exception.*;
import java.util.ArrayList;

public class RiskCodeMap 
{
	//0 = Green if no risk
	//(0:3] Blue, low risk
	//(3:7] Yellow, general risk
	//(7:10] Orange, significant risk
	//(10:inf] Red, severe risk

	private char[][] riskCode;
    	public RiskCodeMap() 
    	{
			this.riskCode = new char[20][10];
    	}
    	/**
	*
	* @return boolean: true if the function could update the risk code in that region 
	*/
    	public boolean updateRiskInARegion(int VIndex,int HIndex,int caseCount,ArrayList<Integer> neighboursCaseCount)
    	{
			int value = 0;

			for(Integer i : neighboursCaseCount) {
				value += i;
			}

			if (value == 0)
				this.riskCode[VIndex][HIndex] = 'G';
			else if (value >= 0 && value < 3)
				this.riskCode[VIndex][HIndex] = 'B';
			else if (value >= 3 && value < 7)
				this.riskCode[VIndex][HIndex] = 'Y';
			else if (value >= 7 && value < 10)
				this.riskCode[VIndex][HIndex] = 'O';
			else if (value >= 10)
				this.riskCode[VIndex][HIndex] = 'R';

    		return true;
    	}
    	public char getRiskInARegion(int VIndex,int HIndex) throws IndexOutOfBoundsException
    	{
    	    	//ToDo: add your code here (you can update the return statement) 
    		return this.riskCode[VIndex][HIndex];
    	}
}
