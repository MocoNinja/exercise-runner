package es.moconinja.exerciserunner.args;

/**
 * Abstraction of a value of any type with a key
 * @param <T>
 */
public class Arg<T> {
    private final String key;
    private final T value;

    public Arg(String key, T value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public T getValue() {
        return value;
    }
}
