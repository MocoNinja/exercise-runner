package es.moconinja.exerciserunner.exercise.examples;

import es.moconinja.exerciserunner.args.Args;
import es.moconinja.exerciserunner.exercise.BaseExercise;

public class HelloWorldExercise extends BaseExercise {

    public HelloWorldExercise(final Args args) {
        super(args);
    }

    @Override
    public void perfomLogic() {
        getLogger().info("Hello World!");
    }
}
