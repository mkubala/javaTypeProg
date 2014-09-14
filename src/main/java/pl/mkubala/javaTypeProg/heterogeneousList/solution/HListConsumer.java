package pl.mkubala.javaTypeProg.heterogeneousList.solution;

import java.math.BigDecimal;

final class HListConsumer {

    private static void expectListOfStringAndDecimal(final HList<String, HList<BigDecimal, HNil>> list) {
        System.out.println(list.head() + " eats " + list.tail().head() + " kg of beetroots each day.");
    }

    private static void expectListStartingWithTwoStrings(final HList<String, ? extends HList<String, ?>> list) {
        System.out.println(list.head());
    }

    private static int size(final HList<?, ?> list) {
        if (list.isEmpty()) {
            return 0;
        }
        return 1 + size(list.tail());
    }

    public static void main(String[] args) {
        HList<BigDecimal, HNil> bigDecimalList = HList.of(BigDecimal.TEN);
        HList<String, HList<BigDecimal, HNil>> strBDecimalList = bigDecimalList.prepend("Maku");
        HList<Long, HList<BigDecimal, HNil>> longBDecimalList = bigDecimalList.prepend(3L);

        expectListOfStringAndDecimal(strBDecimalList);
        expectListOfStringAndDecimal(HList.cons("Maku", HList.of(BigDecimal.TEN)));
        // expectListOfStringAndDecimal(HList.of("s")); // won't compile
        // expectListOfStringAndDecimal(longBDecimalList); // won't compile

        expectListStartingWithTwoStrings(HList.cons("Marcin", HList.cons("Maku", HList.of(BigDecimal.ZERO))));
        // expectListStartingWithTwoStrings(HList.cons("Marcin", HList.cons(5L, HList.of(BigDecimal.ZERO)))); // won't compile

        assert (4 == size(HList.of(1).prepend(2).prepend(3).prepend(4)));
        assert (2 == size(longBDecimalList));
    }

}
