package pl.mkubala.javaTypeProg.phantomType.solution1;

abstract class Form {

    public Object getData() {
        return new Object();
    }

    public ValidatedForm validate() {
        return (ValidatedForm) this;
    }

    public ProcessedForm process() {
        return (ProcessedForm) this;
    }

}

final class RawForm extends Form {
}

class ValidatedForm extends Form {
}

class ProcessedForm extends ValidatedForm {
}
