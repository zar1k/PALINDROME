package com.intetics.model;

import java.util.Objects;

/**
 * This class represents the data model.
 */
public class CalculatedData implements Comparable<CalculatedData> {
    private long palindrome;
    private long sampleNumberOne;
    private long sampleNumberTwo;

    public CalculatedData(final long palindrome, final long sampleNumberOne, final long sampleNumberTwo) {
        this.palindrome = palindrome;
        this.sampleNumberOne = sampleNumberOne;
        this.sampleNumberTwo = sampleNumberTwo;
    }

    public long getPalindrome() {
        return palindrome;
    }

    public long getSampleNumberOne() {
        return sampleNumberOne;
    }

    public long getSampleNumberTwo() {
        return sampleNumberTwo;
    }

    @Override
    public int compareTo(CalculatedData calculatedData) {
        if (this.palindrome > calculatedData.getPalindrome()) {
            return 1;
        } else if (this.palindrome < calculatedData.getPalindrome()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CalculatedData)) return false;
        CalculatedData calculatedData = (CalculatedData) o;
        return getPalindrome() == calculatedData.getPalindrome() &&
                getSampleNumberOne() == calculatedData.getSampleNumberOne() &&
                getSampleNumberTwo() == calculatedData.getSampleNumberTwo();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPalindrome(), getSampleNumberOne(), getSampleNumberTwo());
    }
}