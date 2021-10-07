package io.github.mrslimediamond.openlogger;

import java.util.Map;
import java.util.HashMap;

import static io.github.mrslimediamond.openlogger.CallerClassName.*;

/**
 * Main class for OpenLogger.
 */
public class OpenLogger {

    private static Map<String, Log> packages = new HashMap<>();
    private static final ThreadLocal<Log> DEFAULT_LOG = new ThreadLocal<Log>() {

        @Override
        protected Log initialValue() {
            return new Log();
        }
    };

    public static void info(Object in) {
        getDefaultLog().info(in);
    }
    public static void error(Object in) {
        getDefaultLog().error(in);
    }
    public static void warn(Object in) {
        getDefaultLog().warn(in);
    }
    public static void debug(Object in) {
        getDefaultLog().debug(in);
    }

    public static Log getDefaultLog() {
        String callerClassName = getFullCallerClassName();

        for (Map.Entry<String, Log> entry : packages.entrySet()) {
            if (callerClassName.startsWith(entry.getKey())) {
                return entry.getValue();
            }
        }

        return DEFAULT_LOG.get();
    }

    /**
     * Sets the default log for a package.
     * @param prefix The package prefix (e.g. <code>my.awesome.application</code>).
     * @param log The log.
     */
    public static void setDefaultLog(String prefix, Log log) {
        if(!prefix.endsWith(".")) {
            prefix += ".";
        }
        packages.put(prefix, log);
    }

    public static void removeDefaultLog(String prefix) {
        if(!prefix.endsWith(".")) {
            prefix += ".";
        }
        packages.remove(prefix);
    }

    private OpenLogger() {
        throw new UnsupportedOperationException("OpenLogger cannot be initialized.");
    }

}
