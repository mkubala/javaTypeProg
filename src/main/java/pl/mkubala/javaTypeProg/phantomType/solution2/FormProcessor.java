package pl.mkubala.javaTypeProg.phantomType.solution2;

public final class FormProcessor {

    private static Form<Validated> validate(final Form<Raw> form) {
        return form.validate();
    }

    private static Form<Processed> process(final Form<Validated> form) {
        return form.process();
    }

    private static void archive(final Form<Processed> form) {
        // do sthg
    }

    public static void main(final String[] args) {
        Form<Raw> form = Form.fromUserInput();

        Form<Validated> validatedForm = validate(form);
        Form<Processed> processedForm = process(validatedForm);
        archive(processedForm);

        // validate(processedForm); // won't compile
    }

}
