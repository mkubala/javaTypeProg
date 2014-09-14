package pl.mkubala.javaTypeProg.heterogeneousList.problem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RegularListConsumer {

    private static void expectListOfStringAndDecimal(final List<?> list) {
        if (list.size() != 2) {
            throw new IllegalArgumentException("Expected 2-elements list");
        }
        if (!list.get(0).getClass().equals(String.class)) {
            throw new IllegalArgumentException("First elem of list should be a String");
        }
        if (!list.get(1).getClass().equals(BigDecimal.class)) {
            throw new IllegalArgumentException("Second elem of list should be a BigDecimal");
        }
        System.out.println(list.get(0) + " eats " + list.get(1) + " kg of beetroots each day.");
    }

    private static void expectListStartingWithTwoStrings(final List<?> list) {
        if (list.size() < 2) {
            throw new IllegalArgumentException("Expected at least 2-elements length list");
        }
        if (!list.get(0).getClass().equals(String.class)) {
            throw new IllegalArgumentException("First elem of list should be a String");
        }
        if (!list.get(1).getClass().equals(String.class)) {
            throw new IllegalArgumentException("Second elem of list should be a BigDecimal");
        }
        System.out.println(list.get(0) + ", " + list.get(1));
    }

    private static int size(final List<?> list) {
        return list.size();
    }

    public static void main(String[] args) {
        List<Object> strAndBDecimalList = new ArrayList<Object>();
        Collections.addAll(strAndBDecimalList, "Maku", BigDecimal.TEN);

        List<Object> longAndBDecimalList = new ArrayList<Object>();
        Collections.addAll(longAndBDecimalList, 3L, BigDecimal.ZERO);

        List<Object> twoStringsAndThreeIntegerList = new ArrayList<Object>(); // homogeneous list
        Collections.addAll(twoStringsAndThreeIntegerList, "one", "two", 3, 2, 1);

        List<String> fiveStringsList = new ArrayList<String>(); // homogeneous list
        Collections.addAll(fiveStringsList, "one", "two", "three", "four", "five");

        expectListOfStringAndDecimal(strAndBDecimalList);
        // expectListOfStringAndDecimal(longAndBDecimalList); // will throw an exception

        expectListStartingWithTwoStrings(twoStringsAndThreeIntegerList);
        expectListStartingWithTwoStrings(fiveStringsList);
        // expectListStartingWithTwoStrings(longAndBDecimalList); // will throw an exception

        assert (5 == size(twoStringsAndThreeIntegerList));
    }

}
