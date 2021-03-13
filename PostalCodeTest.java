package com.uregina.app;

//import com.uregina.exception.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

//comment this line if running on cmd
import jdk.jfr.Timestamp;

/**
 * Unit test for simple PostalCode.
 */
public class PostalCodeTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void ValidPostalCodeTrue() {
        try {
            PostalCode code = new PostalCode("K1B-4J2");
            assertTrue(code.isValidPostalCode(code.getPostalCode()));
        } catch (Exception e) {
            //
            // assertEquals();
        }

    }

    @Test
    public void InvalidPostalCode_BadPrefix() {
        try {
            PostalCode code = new PostalCode("K2B-4J2");
            assertFalse(code.isValidPostalCode(code.getPostalCode()));
        } catch (Exception e) {
            //
            //
        }
    }

    @Test
    public void InvalidPostalCode_VindexOutOfRange() {
        try {
            PostalCode code = new PostalCode("K1Z-4J2");
            assertFalse(code.isValidPostalCode(code.getPostalCode()));
        } catch (Exception e) {
            //
        }
    }

    @Test
    public void InvalidPostalCode_VindexNotChar() {
        try {
            PostalCode code = new PostalCode("K11-4J2");
            assertFalse(code.isValidPostalCode(code.getPostalCode()));
        } catch (Exception e) {
            //
        }
    }

    @Test
    public void InvalidPostalCode_HindexNotInt() {
        try {
            PostalCode code = new PostalCode("K1B-CJ2");
            assertFalse(code.isValidPostalCode(code.getPostalCode()));
        } catch (Exception e) {
            //
        }
    }

    @Test
    public void InvalidPostalCode_NoDash() {
        try {
            PostalCode code = new PostalCode("K1B4J2");
            assertFalse(code.isValidPostalCode(code.getPostalCode()));
        } catch (Exception e) {
            //
        }
    }

    @Test
    public void InvalidPostalCode_XisNotUpper() {
        try {
            PostalCode code = new PostalCode("K1B-4j2");
            assertFalse(code.isValidPostalCode(code.getPostalCode()));
        } catch (Exception e) {
            //
        }
    }

    @Test
    public void InvalidPostalCode_XisNotLetter() {
        try {
            PostalCode code = new PostalCode("K1B-432");
            assertFalse(code.isValidPostalCode(code.getPostalCode()));
        } catch (Exception e) {
            //
        }
    }

    @Test
    public void InvalidPostalCode_YisNotInt() {
        try {
            PostalCode code = new PostalCode("K1B-4JX");
            assertFalse(code.isValidPostalCode(code.getPostalCode()));
        } catch (Exception e) {
            // invalid throw
        }
    }

    @Test
    public void ConstructorThrowsException() {

    }

    @Test
    public void ConstructorWorks() {
        try {
            PostalCode code = new PostalCode("K1B-4J2");
            assertEquals(code.getRegionHorizontalIndex(), 4);
            assertEquals(code.getRegionVerticalIndex(), 1);
            assertEquals(code.getPostalCode(), "K1B-4J2");
        } catch (Exception e) {
            //
        }
    }
}
