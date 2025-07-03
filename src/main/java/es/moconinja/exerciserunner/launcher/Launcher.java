package es.moconinja.exerciserunner.launcher;

import es.moconinja.exerciserunner.exercise.BaseExercise;

public class Launcher {
    public static void launch(final BaseExercise exercise) {
        exercise.launchExercise();
    }
}
