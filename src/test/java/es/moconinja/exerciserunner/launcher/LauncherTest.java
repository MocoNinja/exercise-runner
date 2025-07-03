package es.moconinja.exerciserunner.launcher;

import es.moconinja.exerciserunner.exercise.BaseExercise;
import es.moconinja.exerciserunner.exercise.examples.HelloWorldExercise;
import org.junit.jupiter.api.Test;

import static es.moconinja.exerciserunner.utils.Utils.assertThatBaseExerciseLogContainsMessage;
import static org.junit.jupiter.api.Assertions.assertNull;

class LauncherTest {

    @Test
    void userLauncher_ShouldLaunchExercise() {
        final BaseExercise subClass = new HelloWorldExercise(null);
        assertNull(subClass.getArgs(), "No args were passed");
        assertThatBaseExerciseLogContainsMessage(() -> {
                    Launcher.launch(subClass);
                },
                "Init exercise \"es.moconinja.exerciserunner.exercise.examples.HelloWorldExercise\" at: ",
                "Hello World!",
                "End exercise \"es.moconinja.exerciserunner.exercise.examples.HelloWorldExercise\" at: "
        );
    }
}
