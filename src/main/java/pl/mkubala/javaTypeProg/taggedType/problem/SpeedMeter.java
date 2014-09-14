package pl.mkubala.javaTypeProg.taggedType.problem;

import java.math.BigDecimal;

/*
 * Very often we are using the same type to express values of different kinds.
 * In this example we will using Long to represent both, speed and distance values.
 */
public final class SpeedMeter {

    private static BigDecimal countSpeed(final Long distance, final Long time) {
        return BigDecimal.valueOf(distance).divide(BigDecimal.valueOf(time));
    }

    public static void main(String[] args) {
        long distance = 100 * 1000; // 100 km
        long time = 2 * 60 * 60 * 60; // 2h

        countSpeed(distance, time);
        countSpeed(time, distance); // mistake!
    }

}
