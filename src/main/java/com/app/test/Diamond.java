package com.app.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Diamond {

    public static char first_letter = 'A';

    /**
     * method to validate the input, converts the input from lower case to upper case and print letter in diamond shape
     * @param middleLetter - alphabets input
     * @return - List of String in diamond shape
     */
    public List<String> printDiamonds(final char middleLetter) {

        if (!Character.isAlphabetic(middleLetter)) {
            throw new AlphabetException("middle letter passed is not an alphabet : " + middleLetter);
        }
        char letter = middleLetter;
        if (Character.isLowerCase(middleLetter)) {
            letter = Character.toUpperCase(middleLetter);
        }

        List<String> upperHalfDiamond = printUpperHalf(letter);
        List<String> bottomHalfDiamond = printBottomHalf(upperHalfDiamond);
        upperHalfDiamond.addAll(bottomHalfDiamond);
        return upperHalfDiamond;
    }

    public List<String> printUpperHalf(final char middleLetter) {
        int difference_between_letter = middleLetter - first_letter;

        List<String> diamonds = new ArrayList<>();
        diamonds.add(printFirstRow(first_letter, difference_between_letter));

        for (int i = 1; i <= difference_between_letter; i++) {
            char currentLetter = (char) (first_letter + i);
            String firstHalfDiamonds = printOuterDashes(middleLetter - currentLetter) +
                         currentLetter +
                         printInnerDashes(currentLetter - first_letter) +
                         currentLetter +
                         printOuterDashes(middleLetter - currentLetter);

            diamonds.add(firstHalfDiamonds);
        }

        return diamonds;
    }

    public List<String> printBottomHalf(List<String> upperHalfDiamond) {
        List<String> diamondList = new ArrayList<>(upperHalfDiamond);
        Collections.reverse(diamondList);
        diamondList.remove(0);
        return diamondList;
    }

    private String printOuterDashes(final int count) {
        return printDashes(count);
    }

    private String printInnerDashes(final int count) {
        return printDashes(count * 2 -1);
    }

    private String printFirstRow(final char letter, int difference_between_letter) {
        String dashes = printDashes(difference_between_letter);
        return dashes + letter + dashes;
    }

    private String printDashes(final int count) {
        String space = "";
        for (int i = 0;i<count;i++) {
            space += "-";
        }
        return space;
    }

    public static void main(String[] args) {
        Diamond diamond = new Diamond();
        List<String> diamondList = diamond.printDiamonds('E');
        for (String s:diamondList) {
            System.out.println(s);
        }
    }
}
