package com.every.alg;

import java.util.ArrayList;
import java.util.List;

// Tag: 17
public class letterCombinationsOfAPhoneNumber {

    private static String[] digitsCombina = new String[]{
        "",
        "",
        "abc",
        "def",
        "ghi",
        "lkj",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"};    

    //solution method
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        // Backtracking method
        return letterCombinations(digits, 0, digitsCombina,result);
    }

    public List<String> letterCombinations(String digits,int i,String[] digitsCombina, List<String> result) {
        if(i < digits.length()){
            // find i
            List<String> tmpR = new ArrayList<>();
            int index = digits.charAt(i)-'0';
            String dividedString = digitsCombina[index];
            if(result==null || result.isEmpty()){
                for (int j = 0; j < dividedString.length(); j++) {
                    tmpR.add(String.valueOf(dividedString.charAt(j)));
                }
            }else{
                for (String tmp: result) {
                    for (int j = 0; j < dividedString.length(); j++) {
                        tmpR.add(tmp+dividedString.charAt(j));
                    }
                }
            }
            return letterCombinations(digits,i+1,digitsCombina,tmpR);
        }
        return result;
    }

    public static void main(String[] args) {
        letterCombinationsOfAPhoneNumber test = new letterCombinationsOfAPhoneNumber();
        System.out.println(test.letterCombinations("23"));
        System.out.println(test.letterCombinations(""));
        System.out.println(test.letterCombinations("2"));
    }
}

// 测试用例
