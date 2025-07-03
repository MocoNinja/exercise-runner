package es.moconinja.exerciserunner.exercise;

import es.moconinja.exerciserunner.args.Args;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Clock;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Base abstract class to launch some code.
 * Extend this and override the {@link BaseExercise#perfomLogic()}
 * Exposes a {@link Logger} through {@link BaseExercise#getLogger()} for convenience.
 */
public abstract class BaseExercise {
    private static final Logger LOG = LoggerFactory.getLogger(BaseExercise.class);
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_DATE_TIME;

    private final String name;
    private final Args args;

    public BaseExercise(final Args args) {
        this.args = args;
        this.name = getClass().getName();
    }

    public abstract void perfomLogic();

    public void launchExercise() {
        final ZonedDateTime initTime = ZonedDateTime.now(Clock.systemDefaultZone());
        LOG.info("Init exercise \"{}\" at: {}", name, FORMATTER.format(initTime));

        perfomLogic();

        final ZonedDateTime endTime = ZonedDateTime.now(Clock.systemDefaultZone());
        LOG.info("End exercise \"{}\" at: {}", name, FORMATTER.format(endTime));
    }

    public Logger getLogger() {
        return LOG;
    }

    public Args getArgs() {
        return args;
    }
}
