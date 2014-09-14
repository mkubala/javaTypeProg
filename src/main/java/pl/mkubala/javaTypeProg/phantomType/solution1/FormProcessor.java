package pl.mkubala.javaTypeProg.phantomType.solution1;

public final class FormProcessor {

    private static ValidatedForm validate(final RawForm form) {
        return form.validate();
    }

    private static ProcessedForm process(final ValidatedForm form) {
        return form.process();
    }

    private static void archive(final ProcessedForm form) {
        // do sthg
    }

    public static void main(final String[] args) {
        RawForm form = new RawForm();

        ValidatedForm validatedForm = validate(form);
        ProcessedForm processedForm = process(validatedForm);
        archive(processedForm);

        // validate(processedForm); // won't compile
    }

}