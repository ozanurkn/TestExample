package com.ozan.testexampleks.helper;

import java.util.regex.Matcher;

public class Utils {

    public boolean checkUserNameValidate(String userName) {  //içerisinde 2 tane digit var mı ve ilk harfi büyük mü kontrolu

        return userName.matches(".*\\d.*") && Character.isUpperCase(userName.charAt(0));
    }

    public boolean checkPasswordValidate(String password){  // digit bulunduran ,büyük harf bulunduran 8 den kucuk 4 den buyuk
        if (password.matches(".*\\d.*") && checkString(password) && password.length() < 8 && password.length() > 4){
            return true;
        }else {
            return false;
        }
    }

    private static boolean checkString(String str) {
        char ch;
        boolean capitalFlag = false;
        boolean lowerCaseFlag = false;
        boolean numberFlag = false;
        for(int i=0;i < str.length();i++) {
            ch = str.charAt(i);
            if( Character.isDigit(ch)) {
                numberFlag = true;
            }
            else if (Character.isUpperCase(ch)) {
                capitalFlag = true;
            } else if (Character.isLowerCase(ch)) {
                lowerCaseFlag = true;
            }
            if(numberFlag && capitalFlag && lowerCaseFlag)
                return true;
        }
        return false;
    }
}
