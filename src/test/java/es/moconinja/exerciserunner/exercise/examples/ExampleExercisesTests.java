package es.moconinja.exerciserunner.exercise.examples;


import es.moconinja.exerciserunner.args.Arg;
import es.moconinja.exerciserunner.args.Args;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static es.moconinja.exerciserunner.utils.Utils.assertThatBaseExerciseLogContainsMessage;

class ExampleExercisesTests {

    @Test
    void testHelloWorld_IsLogged() {
        assertThatBaseExerciseLogContainsMessage(() -> {
            final HelloWorldExercise exercise = new HelloWorldExercise(null);
            exercise.perfomLogic();
        }, "Hello World!");
    }


    @Test
    void testByeWorld_IsLogged() {
        assertThatBaseExerciseLogContainsMessage(() -> {
            final ByeWorldExercise exercise = new ByeWorldExercise(null);
            exercise.perfomLogic();
        }, "Bye World!");

    }

    @ParameterizedTest
    @ValueSource(strings = {"Juan", "Pepe", "Mariko"})
    void testSalutator_IsLogged(final String name) {
        final Args args = new Args(
                new Arg("name", name)
        );
        final String expectedMessage = "Hola, soy %s.".formatted(name);
        assertThatBaseExerciseLogContainsMessage(() -> {
            final SalutatorArgsExercise exercise = new SalutatorArgsExercise(args);
            exercise.perfomLogic();
        }, expectedMessage);
    }

    @ParameterizedTest
    @EnumSource(PresenterArgsExercise.Gender.class)
    void testPresent_IsLogged(final PresenterArgsExercise.Gender gender) {
        final String name = "Ariel";
        final Integer age = new Random().nextInt(0, 69);
        final String expectedMessage = "Hola, soy %s (%s) y tengo %d año(s).".formatted(name, gender, age);
        final Args args = new Args(
                new Arg("name", name),
                new Arg("age", age),
                new Arg("gender", gender)
        );
        assertThatBaseExerciseLogContainsMessage(() -> {
            final PresenterArgsExercise exercise = new PresenterArgsExercise(args);
            exercise.perfomLogic();
        }, expectedMessage);
    }

}