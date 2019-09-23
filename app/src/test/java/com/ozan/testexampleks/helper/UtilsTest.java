package com.ozan.testexampleks.helper;

import android.util.Log;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilsTest {

    private Utils utils;

    @BeforeClass
    public static void beforeClass(){
        System.out.println("in BeforeClass");

    }
    @Before
    public void before(){
        System.out.println("in before");
        utils = new Utils();
    }


    @Test
    public void checkUserNameValidNoDigitFalseTest() {
        System.out.println("in checkUserNameValidNoDigitFalseTest");
        String EXAMPLE_FAKE_NAME = "Ozannn";
        assertFalse(utils.checkUserNameValidate(EXAMPLE_FAKE_NAME));
    }

    @Test
    public void checkUserNameValidNoUpperFirstCharFalseTest() {
        System.out.println("in checkUserNameValidNoUpperFirstCharFalseTest");
        String EXAMPLE_FAKE_NAME = "ozann67";
        assertFalse(utils.checkUserNameValidate(EXAMPLE_FAKE_NAME));
    }

    @Test
    public void checkUserNameValidDifferentCharUpperFalseTest() {
        System.out.println("in checkUserNameValidDifferentCharUpperFalseTest");
        String EXAMPLE_FAKE_NAME = "ozAnn67";
        assertFalse(utils.checkUserNameValidate(EXAMPLE_FAKE_NAME));
    }

    @Test
    public void checkUserNameValidSuccessTest(){
        System.out.println("in checkUserNameValidSuccessTest");
        String EXAMPLE_FAKE_NAME = "Ozann67";
        assertTrue(utils.checkUserNameValidate(EXAMPLE_FAKE_NAME));
    }

    @Test
    public void checkPasswordValidNoUpperCharFalseTest(){
        System.out.println("in checkPasswordValidNoUpperCharFalseTest");
        String EXAMPLE_FAKE_PASSWORD = "ozan12";
        assertFalse(utils.checkPasswordValidate(EXAMPLE_FAKE_PASSWORD));
    }

    @Test
    public void checkPasswordValidNoDigitFalseTest(){
        System.out.println("in checkPasswordValidNoDigitFalseTest");
        String EXAMPLE_FAKE_PASSWORD = "oZann";
        assertFalse(utils.checkPasswordValidate(EXAMPLE_FAKE_PASSWORD));
    }

    @Test
    public void checkPasswordValidLowLengthFalseTest(){
        System.out.println("in checkPasswordValidLowLengthFalseTest");
        String EXAMPLE_FAKE_PASSWORD = "oZ1";
        assertFalse(utils.checkPasswordValidate(EXAMPLE_FAKE_PASSWORD));
    }

    @Test
    public void checkPasswordValidHighLengthFalseTest(){
        System.out.println("in checkPasswordValidHighLengthFalseTest");
        String EXAMPLE_FAKE_PASSWORD = "oZann1212";
        assertFalse(utils.checkPasswordValidate(EXAMPLE_FAKE_PASSWORD));
    }

    @Test
    public void checkUserPasswordValidSuccessTest(){
        System.out.println("in checkUserPasswordValidSuccessTest");
        String EXAMPLE_FAKE_PASSWORD = "oZann67";
        assertTrue(utils.checkPasswordValidate(EXAMPLE_FAKE_PASSWORD));
    }

    @After
    public void after(){
        System.out.println("in after");
        utils = null;
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("in after class");
    }

    @Ignore
    public void ignoreMethod(){
        System.out.println("in ignore class");
    }

}