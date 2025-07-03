package es.moconinja.exerciserunner.exercise.examples;

import es.moconinja.exerciserunner.args.Args;
import es.moconinja.exerciserunner.exercise.BaseExercise;

/**
 * Example {@link BaseExercise} that expects complex {@link Args}
 * It will rely on the given {@link Args} and extract and use it in a simple manner
 */
public class PresenterArgsExercise extends BaseExercise {
    private final String name;
    private final Integer age;
    private final Gender gender;

    public PresenterArgsExercise(final Args args) {
        super(args);
        this.name = args.getArg("name", String.class);
        this.age = args.getArg("age", Integer.class);
        this.gender = args.getArg("gender", Gender.class);
    }

    @Override
    public void perfomLogic() {
        getLogger().info("Hola, soy {} ({}) y tengo {} año(s).", name, gender, age);
    }

    // Polemic, I know 💀
    protected enum Gender {
        MALE,
        FEMALE
    }

    ;
}
