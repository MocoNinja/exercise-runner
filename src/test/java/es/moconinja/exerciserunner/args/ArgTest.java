package es.moconinja.exerciserunner.args;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArgTest {

    @Test
    void argWorks_ForGenericType() {
        final Arg argString = new Arg("key", "value");
        final Arg argNumber = new Arg("integer", 69);

        assertEquals(argString.getKey(), "key");
        assertEquals(argString.getValue(), "value");
        assertEquals(argNumber.getKey(), "integer");
        assertEquals(argNumber.getValue(), 69);
    }
}
