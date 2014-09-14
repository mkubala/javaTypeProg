package pl.mkubala.javaTypeProg.phantomType.problem;

interface Form {

    Object getData();

    boolean isRaw();

    boolean isProcessed();
}

final class FormImpl implements Form {

    private final boolean isRaw;

    private final boolean isProcessed;

    public FormImpl(final boolean isRaw, final boolean isProcessed) {
        this.isRaw = isRaw;
        this.isProcessed = isProcessed;
    }

    @Override
    public Object getData() {
        return new Object();
    }

    @Override
    public boolean isRaw() {
        return isRaw;
    }

    @Override
    public boolean isProcessed() {
        return isProcessed;
    }
}
