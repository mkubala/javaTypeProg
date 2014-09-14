package pl.mkubala.javaTypeProg.heterogeneousList.solution;

// HList is a recursive data type
abstract class HList<H, T extends HList> {

    public abstract H head();

    public abstract T tail();

    public <E> HList<E, HList<H, T>> cons(final E e) {
        return new HCons<E, HList<H, T>>(e, this);
    }

    public <E> HList<E, HList<H, T>> prepend(final E e) {
        return cons(e);
    }

    public abstract boolean isEmpty();

    public static <E> HList<E, HNil> of(final E e) {
        return new HCons<E, HNil>(e, new HNil());
    }

    public static <E, T extends HList> HList<E, T> cons(final E h, final T t) {
        return new HCons<E, T>(h, t);
    }

}

final class HNil<H, T extends HList> extends HList<H, T> {

    @Override
    public H head() {
        throw new IllegalStateException("head on empty list!");
    }

    @Override
    public T tail() {
        throw new IllegalStateException("tail on empty list!");
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this || obj.getClass().equals(this.getClass())) {
            return true;
        }
        return false;
    }
}

final class HCons<H, T extends HList> extends HList<H, T> {

    private final H head;

    private final T tail;

    HCons(final H head, final T tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public H head() {
        return head;
    }

    @Override
    public T tail() {
        return tail;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int hashCode() {
        return head == null ? 0 : head.hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null || !obj.getClass().equals(this.getClass())) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        HCons<? extends Object, ? extends HList> oth = (HCons<? extends Object, ? extends HList>) obj;
        if (oth.head == null) {
            return this.head == null;
        }
        return oth.head.equals(this.head);
    }
}
