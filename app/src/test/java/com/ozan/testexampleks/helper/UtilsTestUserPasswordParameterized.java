package com.ozan.testexampleks.helper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class UtilsTestUserPasswordParameterized {

    private String inComingValue;
    private Boolean expectedResult;
    private Utils utilsTest;

    @Before
    public void initialize(){

        utilsTest = new Utils();
    }

    public UtilsTestUserPasswordParameterized(String inComingValue, Boolean expectedResult) {
        this.inComingValue = inComingValue;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection inComingUserPasswordValues(){
        return Arrays.asList(new Object[][]{
                {"ozan12",false},
                {"oZann",false},
                {"oZ1",false},
                {"oZann1212",false},
                {"oZann67",true}
        });
    }

    @Test
    public void testUserPasswordChecker(){
        assertEquals(expectedResult,utilsTest.checkPasswordValidate(inComingValue));
    }
}