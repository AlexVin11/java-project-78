package hexlet.code;


import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BasicSchema<T> {
    protected List<Predicate<T>> checks = new LinkedList<>();
    protected boolean required = false;

    protected final void addCheck(Predicate<T> predicate) {
        checks.add(predicate);
    }

    public void setRequired() {
        this.required = true;
    }

    public abstract boolean isValid(T t);
}
