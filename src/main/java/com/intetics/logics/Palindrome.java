package com.intetics.logics;

import com.intetics.model.CalculatedData;

import java.util.List;
import java.util.TreeSet;

/**
 * This class contains method returns the largest palindrome.
 */
public final class Palindrome {
    private static TreeSet<CalculatedData> palindromes = new TreeSet<>();

    /**
     * This method checks whether the product of two simple five-digit numbers is a palindrome,
     * if true adds them to the list.
     *
     * @param simpleNumberOne first factor.
     * @param simpleNumberTwo second factor.
     */
    private static void palindromeSearch(long simpleNumberOne, long simpleNumberTwo) {
        long result = simpleNumberOne * simpleNumberTwo;
        String strResult = String.valueOf(result);
        if (strResult.equals(new StringBuilder(strResult).reverse().toString())) {
            palindromes.add(new CalculatedData(result, simpleNumberOne, simpleNumberTwo));
        }
    }

    /**
     * This method returns the largest number of palindromes, which is the product of two simple five-digit numbers,
     * and returns the factors themselves.
     *
     * @param simpleFiveDigitNumbers list of simple five-digit numbers from 10,000 to 99999.
     * @return the object of the class CalculatedData that contains the largest palindrome.
     * @see CalculatedData
     */
    public static CalculatedData getMaxPalindrome(List<Long> simpleFiveDigitNumbers) {
        for (int i = 0; i < simpleFiveDigitNumbers.size(); i++) {
            for (Long number : simpleFiveDigitNumbers) {
                long arg1 = simpleFiveDigitNumbers.get(i);
                long arg2 = number;
                Palindrome.palindromeSearch(arg1, arg2);
            }
        }
        return palindromes.last();
    }
}