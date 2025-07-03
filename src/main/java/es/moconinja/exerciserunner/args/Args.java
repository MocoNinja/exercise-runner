package es.moconinja.exerciserunner.args;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * A Map of {@link Arg}'s, with their respective {@link Arg#getKey()}
 */
public class Args {
    private final Map<String, Arg> argMap;

    public Args(final Arg... args) {
        argMap = new HashMap<>();
        Arrays.stream(args).forEach(arg -> {
            argMap.put(arg.getKey(), arg);
        });
    }

    public void addArg(final Arg arg) {
        argMap.put(arg.getKey(), arg);
    }

    public <T> T getArg(final String key, final Class<T> clazz) {
        final Arg result = argMap.get(key);
        if (result == null) {
            throw new IllegalArgumentException("Argument not found: " + key);
        }
        final Object value = result.getValue();
        if (!clazz.isInstance(value)) {
            throw new IllegalArgumentException("Argument of invalid type: " + key);
        }
        return (T) value;
    }


}
