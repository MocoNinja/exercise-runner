package es.moconinja.exerciserunner.exercise.examples;

import es.moconinja.exerciserunner.args.Args;
import es.moconinja.exerciserunner.exercise.BaseExercise;

/**
 * Example {@link BaseExercise} that expects a parameter of certain type.
 * It will rely on the given {@link Args} and extract and use it in a simple manner
 */
public class SalutatorArgsExercise extends BaseExercise {
    private final String name;

    public SalutatorArgsExercise(final Args args) {
        super(args);
        this.name = args.getArg("name", String.class);
    }

    @Override
    public void perfomLogic() {
        getLogger().info("Hola, soy {}.", name);
    }
}
