package com.ozan.testexampleks.helper;

import junit.framework.TestResult;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class UtilsTestUserNameParameterized {
    private String inComingValue;
    private Boolean expectedResult;
    private Utils utilsTest;

    @BeforeClass
    public static void beforeClass(){
        System.out.println("in BeforeClass");
    }

    @Before
    public void initialize(){
        System.out.println("in before");
        utilsTest = new Utils();
    }

    public UtilsTestUserNameParameterized(String inComingValue, Boolean expectedResult) {
        this.inComingValue = inComingValue;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection inComingUserNameValues(){
        return Arrays.asList(new Object[][]{
                {"Ozannn",false},
                {"ozann67",false},
                {"ozAnn67",false},
                {"Ozann67",true}
        });
    }

    @Test
    public void testUserNameChecker(){
        System.out.println("in Test");
        assertEquals(expectedResult,utilsTest.checkUserNameValidate(inComingValue));
    }

    @After
    public void destroy(){
        System.out.println("in after");
        utilsTest = null;
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("in afterClass");
    }

    @Ignore
    public void ignoreClass(){
        System.out.println("in ignoreClass");
    }
}