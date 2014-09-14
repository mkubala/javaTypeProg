package pl.mkubala.javaTypeProg.taggedType.solution2;

import java.math.BigDecimal;

interface Tag {
} // Tag & its subtypes are phantom types

interface Distance extends Tag {
}

interface Time extends Tag {
}

final class Tagged<V, T extends Tag> {

    final V value;

    @SuppressWarnings("unchecked")
    static <A, B extends Tag> Tagged<A, B> tag(final A value) {
        return new Tagged(value);
    }

    Tagged(final V value) {
        this.value = value;
    }

}

public final class SpeedMeter {

    private static BigDecimal countSpeed(final Tagged<Long, Distance> distance, final Tagged<Long, Time> time) {
        return BigDecimal.valueOf(distance.value).divide(BigDecimal.valueOf(time.value));
    }

    public static void main(String[] args) {
        Tagged<Long, Distance> distance = Tagged.tag(100 * 1000L); // 100 km
        Tagged<Long, Time> time = Tagged.tag(2 * 60 * 60 * 60L); // 2h

        countSpeed(distance, time);
        // countSpeed(time, distance); // won't compile
    }

}
