package hexlet.code;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BasicSchema<T> {
    protected List<Predicate<T>> checks = new ArrayList<>();
    protected boolean required = false;

    protected final void addCheck(Predicate<T> predicate) {
        checks.add(predicate);
    }

    protected final void updateCheck(Predicate<T> predicate) {
        checks.clear();
        checks.add(predicate);
    }

    public void setRequired() {
        this.required = true;
    }

    public abstract boolean isValid(T t);
}
