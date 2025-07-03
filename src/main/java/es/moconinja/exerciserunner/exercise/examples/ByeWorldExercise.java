package es.moconinja.exerciserunner.exercise.examples;

import es.moconinja.exerciserunner.args.Args;
import es.moconinja.exerciserunner.exercise.BaseExercise;

public class ByeWorldExercise extends BaseExercise {

    public ByeWorldExercise(final Args args) {
        super(args);
    }

    @Override
    public void perfomLogic() {
        getLogger().info("Bye World!");
    }

}
