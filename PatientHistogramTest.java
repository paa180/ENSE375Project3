package com.uregina.app;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for PatientHistogram.
 */
public class PatientHistogramTest {

    /*
     * null_count_check checks for empty array should return 0
     */
    @Test
    public void null_count_check() {
        PatientHistogram histogram = new PatientHistogram();
        int VIndex = 0, HIndex = 0;
        int result = histogram.getPatientsCountInRegion(VIndex, HIndex);
        assertEquals(result, 0);
    }

    /*
     * should_Add_True checks for valid input Should return true
     */
    @Test
    public void should_Add_True() {
        PatientHistogram histogram = new PatientHistogram();
        int VIndex = 0, HIndex = 0;
        boolean check = histogram.addAPatientToRegion(VIndex, HIndex);
        assertTrue(check);
    }

    // /*
    //  * It checks for the same horizontal and vertical values If already exists, it
    //  * should not add any patient, If no patient exists, it will add Return True
    //  */
    // @Test
    // public void should_Add_T() {
    //     PatientHistogram histogram = new PatientHistogram();
    //     histogram.addAPatientToRegion(0, 0);
    //     int VIndex = 0, HIndex = 0;
    //     boolean check = histogram.addAPatientToRegion(VIndex, HIndex);
    //     assertTrue(check);
    // }

    /*
     * Check for upper boundary cases: I will try to add the value on 19:Vertical
     * index and 9:Horizontal index
     * 
     */
    @Test
    public void valid_boundaryCheck_True() {
        PatientHistogram histogram = new PatientHistogram();
        int VIndex = 19, HIndex = 9;
        boolean check = histogram.addAPatientToRegion(VIndex, HIndex);
        assertTrue(check);
    }

    /*
     * Check for out of boundary cases: I will try to add the value on 20:Vertical
     * index and 10:Horizontal index Should return false
     */
    @Test
    public void Invalid_boundaryCheck_False() {
        PatientHistogram histogram = new PatientHistogram();
        int VIndex = 20, HIndex = 100;
        boolean check = histogram.addAPatientToRegion(VIndex, HIndex);
        assertFalse(check);
    }

    /*
     * valid_count_True checks for valid patient count in that region should return
     * 1
     */
    @Test
    public void valid_count_Equals() {
        PatientHistogram histogram = new PatientHistogram();
        int VIndex = 1, HIndex = 0;
        histogram.addAPatientToRegion(VIndex, HIndex);
        int result = histogram.getPatientsCountInRegion(VIndex, HIndex);
        assertEquals(result, 1);
    }

    /*
     * Invalid_check_False checks Invalid or out of boundary exception if it is out
     * of boundary: should return -1
     */
    @Test
    public void Ivalid_check_Equals() {
        PatientHistogram histogram = new PatientHistogram();
        int VIndex = 20, HIndex = 100;
        int result = histogram.getPatientsCountInRegion(VIndex, HIndex);
        assertEquals(result, -1);
    }

    /*
     * delete_True checks for 1 in the array if patient exists, it will remove the
     * patient should return true
     */
    @Test
    public void delete_True() {
        PatientHistogram histogram = new PatientHistogram();
        int VIndex = 19, HIndex = 0;
        histogram.addAPatientToRegion(VIndex, HIndex);
        boolean result = histogram.deleteAPatientFromRegion(VIndex, HIndex);
        assertTrue(result);
    }

    /*
     * delete_false checks for 1 in the array No patient exists should return false
     */
    @Test
    public void delete_False() {
        PatientHistogram histogram = new PatientHistogram();
        int VIndex = 19, HIndex = 9;
        boolean result = histogram.deleteAPatientFromRegion(VIndex, HIndex);
        assertFalse(result);
    }

    /*
     * delete_True checks out of boundary arbitrary values throws exception should
     * return false
     */
    @Test
    public void delete_outOfBoundary_false() {
        PatientHistogram histogram = new PatientHistogram();
        int VIndex = 1000, HIndex = 2000;
        boolean result = histogram.deleteAPatientFromRegion(VIndex, HIndex);
        assertFalse(result);
    }
}
