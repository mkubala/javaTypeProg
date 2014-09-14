package pl.mkubala.javaTypeProg.phantomType.solution2;

interface State {
}

interface Raw extends State {
}

interface Validated extends State {
}

interface Processed extends Validated {
}

final class Form<S extends State> {

    @SuppressWarnings("unchecked")
    public static Form<Raw> fromUserInput() {
        return (Form<Raw>) new Form();
    }

    public Object getData() {
        return new Object();
    }

    @SuppressWarnings("unchecked")
    public Form<Validated> validate() {
        return (Form<Validated>) this;
    }

    @SuppressWarnings("unchecked")
    public Form<Processed> process() {
        return (Form<Processed>) this;
    }

}
