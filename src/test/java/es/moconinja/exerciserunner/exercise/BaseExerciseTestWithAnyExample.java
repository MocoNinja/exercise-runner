package es.moconinja.exerciserunner.exercise;

import es.moconinja.exerciserunner.args.Arg;
import es.moconinja.exerciserunner.args.Args;
import es.moconinja.exerciserunner.exercise.examples.HelloWorldExercise;
import es.moconinja.exerciserunner.exercise.examples.SalutatorArgsExercise;
import org.junit.jupiter.api.Test;

import static es.moconinja.exerciserunner.utils.Utils.assertThatBaseExerciseLogContainsMessage;
import static org.junit.jupiter.api.Assertions.*;

class BaseExerciseTestWithAnyExample {

    @Test
    void subclass_NoArgs_WorksAsExpected() {
        final BaseExercise subClass = new HelloWorldExercise(null);
        assertNull(subClass.getArgs(), "No args were passed");
        assertThatBaseExerciseLogContainsMessage(() -> {
                    subClass.launchExercise();
                },
                "Init exercise \"es.moconinja.exerciserunner.exercise.examples.HelloWorldExercise\" at: ",
                "Hello World!",
                "End exercise \"es.moconinja.exerciserunner.exercise.examples.HelloWorldExercise\" at: "
        );
    }

    @Test
    void subclass_WithArgs_WorksAsExpected() {
        final Args nameArgs = new Args(
                new Arg("name", "juan")
        );

        final SalutatorArgsExercise subClass = new SalutatorArgsExercise(nameArgs);
        assertNotNull(subClass.getArgs(), "Args were passed");
        assertEquals(subClass.getArgs(), nameArgs);
        assertThatBaseExerciseLogContainsMessage(() -> {
                    subClass.launchExercise();
                },
                "Init exercise \"es.moconinja.exerciserunner.exercise.examples.SalutatorArgsExercise\" at: ",
                "Hola, soy juan.",
                "End exercise \"es.moconinja.exerciserunner.exercise.examples.SalutatorArgsExercise\" at: "
        );
    }
}
