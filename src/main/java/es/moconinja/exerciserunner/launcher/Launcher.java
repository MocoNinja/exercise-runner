package es.moconinja.exerciserunner.launcher;

import es.moconinja.exerciserunner.exercise.BaseExercise;

/**
 * Simple class to launch any {@link BaseExercise} from a main or whatever
 */
public final class Launcher {
    private Launcher() {}
    public static void launch(final BaseExercise exercise) {
        exercise.launchExercise();
    }
}
