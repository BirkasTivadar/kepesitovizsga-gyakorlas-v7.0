package hu.nive.ujratervezes.kepesitovizsga.finelongwordonceagain;

public class FineLongWordOnceAgain {


    public char[][] getFineLongWordOnceAgainButNowInAReverseWay(String word, int lengthOfParts) {

        if (lengthOfParts > word.length()) {
            throw new IllegalArgumentException("Number of letters cannot be more than length of the word!");
        }

        char[][] result = new char[word.length() - lengthOfParts + 1][];
        int rowCounter = 0;

        while (word.length() >= lengthOfParts) {
            String part = word.substring(0, lengthOfParts).toUpperCase();
            word = word.substring(1);
            result[rowCounter] = part.toCharArray();
            rowCounter++;
        }

        return result;
    }
}
