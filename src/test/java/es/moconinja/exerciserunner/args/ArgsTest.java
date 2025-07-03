package es.moconinja.exerciserunner.args;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArgsTest {
    private static final Args argsWithStringKey = new Args(
            new Arg("key", "value")
    );

    @Test
    void getPresentArg_WorksAsExpected() {
        final String result = argsWithStringKey.getArg("key", String.class);
        assertEquals("value", result);
    }

    @Test
    void getMissingArgs_ThrowsException() {
        final var thrown = assertThrows(IllegalArgumentException.class, () -> {
            argsWithStringKey.getArg("keyy", String.class);
        });
        assertEquals("Argument not found: keyy", thrown.getMessage());
    }

    @Test
    void getPresentArgs_OfWrongType_ThrowsException() {
        final var thrown = assertThrows(IllegalArgumentException.class, () -> {
            argsWithStringKey.getArg("key", Integer.class);
        });
        assertEquals("Argument of invalid type: key", thrown.getMessage());
    }

    @Test
    void addNewArg_WorksAsExpected() {
        final Args emptyArgsInTheBeginning = new Args();
        final var thrown = assertThrows(IllegalArgumentException.class, () -> {
            emptyArgsInTheBeginning.getArg("key", String.class);
        });
        assertEquals("Argument not found: key", thrown.getMessage());

        emptyArgsInTheBeginning.addArg(
                new Arg("key", "value")
        );

        final String result = emptyArgsInTheBeginning.getArg("key", String.class);
        assertEquals("value", result);
    }
}
