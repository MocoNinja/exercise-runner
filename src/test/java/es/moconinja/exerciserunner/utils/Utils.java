package es.moconinja.exerciserunner.utils;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public final class Utils {
    public static void assertThatBaseExerciseLogContainsMessage(final Runnable codeToTest, final String... messages) {
        final Logger logger = (Logger) LoggerFactory.getLogger("es.moconinja.exerciserunner.exercise.BaseExercise");
        final ListAppender<ILoggingEvent> listAppender = new ListAppender<>();

        listAppender.start();
        logger.addAppender(listAppender);

        codeToTest.run();

        var logsList = listAppender.list;

        for (String message : messages) {
            boolean found = logsList.stream()
                    .anyMatch(event -> event.getFormattedMessage().contains(message));

            assertTrue(found, "Expected '%s' log message not found.".formatted(message));
        }

        logger.detachAppender(listAppender);
    }
}
