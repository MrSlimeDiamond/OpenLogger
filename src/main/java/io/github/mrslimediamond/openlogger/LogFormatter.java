package io.github.mrslimediamond.openlogger;

import static io.github.mrslimediamond.openlogger.LogConstants.*;

public interface LogFormatter {

    public static LogFormatter DEFAULT = (level, caller, in) -> {
        switch(level) {
            case INFO:
                return "["+caller+"/"+ANSI_CYAN+"INFO"+ANSI_RESET+"] "+in;
            case WARN:
                return ANSI_YELLOW+"["+caller+"/WARN] "+in+ANSI_RESET;
            case ERROR:
                return ANSI_RED+"["+caller+"/ERROR] "+in+ANSI_RESET;
            case DEBUG:
                return "["+caller+"/"+ANSI_PURPLE+"DEBUG"+ANSI_RESET+"] "+in;
            default:
                return "["+caller+"/"+level+"] "+in;
        }
    };

    public String format(LogLevel level, String caller, Object in);
}
