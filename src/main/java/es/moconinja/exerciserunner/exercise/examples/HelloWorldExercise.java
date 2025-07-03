package es.moconinja.exerciserunner.exercise.examples;

import es.moconinja.exerciserunner.args.Args;
import es.moconinja.exerciserunner.exercise.BaseExercise;


/**
 * Example {@link BaseExercise} that say's hello
 */
public class HelloWorldExercise extends BaseExercise {

    public HelloWorldExercise(final Args args) {
        super(args);
    }

    @Override
    public void perfomLogic() {
        getLogger().info("Hello World!");
    }
}
