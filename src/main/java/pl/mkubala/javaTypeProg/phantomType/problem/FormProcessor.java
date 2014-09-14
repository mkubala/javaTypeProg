package pl.mkubala.javaTypeProg.phantomType.problem;

public final class FormProcessor {

    private static Form validate(final Form form) {
        if (!form.isRaw()) {
            throw new IllegalArgumentException("Re-validating already validated form!");
        }
        if (form.isProcessed()) {
            throw new IllegalArgumentException("Re-validating processed form!");
        }
        return new FormImpl(false, form.isProcessed());
    }

    private static Form process(final Form form) {
        if (form.isRaw()) {
            throw new IllegalArgumentException("Can't process untrusted form, validate it first!");
        }
        if (form.isProcessed()) {
            throw new IllegalArgumentException("Form is already processed!");
        }
        return new FormImpl(form.isRaw(), true);
    }

    private static void archive(final Form form) {
        if (form.isRaw()) {
            throw new IllegalArgumentException("Can't archive untrusted, raw form..");
        }
        if (!form.isProcessed()) {
            throw new IllegalArgumentException("Form have to be processed before archived");
        }
        // do sthg
    }

    public static void main(final String[] args) {
        Form form = new FormImpl(true, false);

        Form validatedForm = validate(form); // ok
        Form processedForm = process(validatedForm); // ok
        archive(processedForm); // ok

        // validate(processedForm); // will throw an IllegalArgumentException at runtime
    }

}
