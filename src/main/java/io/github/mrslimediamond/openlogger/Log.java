package io.github.mrslimediamond.openlogger;

import static io.github.mrslimediamond.openlogger.CallerClassName.*;

public class Log {

    private final LogFormatter formatter;
    private LogLevel level;

    /**
     * Creates a new log.
     * @param formatter The log formatter (defaults to {@link LogFormatter#DEFAULT}).
     * @param level The log level. No messages of levels more verbose than the one provided will be displayed.
     */
    public Log(LogFormatter formatter, LogLevel level) {
        this.formatter = formatter;
        this.level = level;
    }

    /**
     * Creates a new log.
     * @param formatter The log formatter (defaults to {@link LogFormatter#DEFAULT}).
     */
    public Log(LogFormatter formatter) {
        this(formatter, LogLevel.DEBUG);
    }

    /**
     * Creates a new log.
     * @param level The log level. No messages of levels more verbose than the one provided will be displayed.
     */
    public Log(LogLevel level) {
        this(LogFormatter.DEFAULT, level);
    }

    /**
     * Creates a new log with defaults.

     */
    public Log() {
        this(LogFormatter.DEFAULT, LogLevel.DEBUG);
    }

    public void log(LogLevel level, Object in) {
        if (this.level.ordinal() <= level.ordinal()) {
            System.out.println(formatter.format(level, getCallerClassName(), in));
        }
    }
    public void debug(Object in) {
        log(LogLevel.DEBUG, in);
    }
    public void info(Object in) {
        log(LogLevel.INFO, in);
    }
    public void warn(Object in) {
        log(LogLevel.WARN, in);
    }
    public void error(Object in) {
        log(LogLevel.ERROR, in);
    }
}

