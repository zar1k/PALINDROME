package com.intetics;

import com.intetics.model.CalculatedData;
import com.intetics.logics.Palindrome;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final String SOURCE_DATA = "src\\main\\resources\\numbers.txt";

    public static void main(String[] args) throws IOException {
        File file = new File(SOURCE_DATA);
        String path = file.getAbsolutePath();
        List<Long> simpleFiveDigitNumbers = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            simpleFiveDigitNumbers = br.lines().map(Long::valueOf).collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Having problems reading from a file.");
        }

        CalculatedData maxPalindrome = Palindrome.getMaxPalindrome(simpleFiveDigitNumbers);

        System.out.println("-------------------------------------------------------");
        System.out.printf("%-10s| %-10s| %-30s\n", "The maximum palindrome", "First argument", "Second argument");
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-22d| %-14d| %-22s", maxPalindrome.getPalindrome(), maxPalindrome.getSampleNumberOne(), maxPalindrome.getSampleNumberTwo());
    }
}
