package pl.mkubala.javaTypeProg.taggedType.solution1;

import java.math.BigDecimal;

final class Distance {

    public final Long value;

    Distance(final Long value) {
        this.value = value;
    }

    // equals & hashCode goes here
}

final class Time {

    public final Long value;

    Time(final Long value) {
        this.value = value;
    }

    // equals & hashCode goes here
}

public final class SpeedMeter {

    private static BigDecimal countSpeed(final Distance distance, final Time time) {
        return BigDecimal.valueOf(distance.value).divide(BigDecimal.valueOf(time.value));
    }

    public static void main(String[] args) {
        Distance distance = new Distance(100 * 1000L); // 100 km
        Time time = new Time(2 * 60 * 60 * 60L); // 2h

        countSpeed(distance, time);
        // countSpeed(time, distance); // won't compile
    }

}
