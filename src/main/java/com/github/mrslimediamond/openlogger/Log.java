package com.github.mrslimediamond.openlogger;

public class Log {
    /* Colours and stuff */

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    /* Yayyy, stackoverflow! */

    static class KDebug {
        public static String getCallerClassName0() {
            StackTraceElement[] stElements = Thread.currentThread().getStackTrace();
            for (int i=1; i<stElements.length; i++) {
                StackTraceElement ste = stElements[i];
                if (!ste.getClassName().equals(KDebug.class.getName()) && ste.getClassName().indexOf("java.lang.Thread")!=0) {
                    return ste.getClassName();
                }
            }
            return null;
        }
    }
    public static StackTraceElement getCallerClassName1() {
        StackTraceElement[] stElements = Thread.currentThread().getStackTrace();
        String callerClassName = null;
        for (int i=1; i<stElements.length; i++) {
            StackTraceElement ste = stElements[i];
            if (!ste.getClassName().equals(KDebug.class.getName())&& ste.getClassName().indexOf("java.lang.Thread")!=0) {
                if (callerClassName==null) {
                    callerClassName = ste.getClassName();
                } else if (!callerClassName.equals(ste.getClassName())) {
                    return ste;
                }
            }
        }
        return null;
    }
    public static String getCallerClassName() {
        String classNameFull = getCallerClassName1().getFileName();
        int lineNum = getCallerClassName1().getLineNumber();
        String[] className = classNameFull.split(".java");
        return className[0];
    }

    public static void info(Object in) {
        System.out.println("["+getCallerClassName()+"/"+ANSI_CYAN+"INFO"+ANSI_RESET+"] "+in);
    }
    public static void error(Object in) {
        System.out.println(ANSI_RED+"["+getCallerClassName()+"/ERROR] "+in+ANSI_RESET);
    }
    public static void warn(Object in) {
        System.out.println(ANSI_YELLOW+"["+getCallerClassName()+"/WARN] "+in+ANSI_RESET);
    }
    public static void debug(Object in) {
        System.out.println("["+getCallerClassName()+"/"+ANSI_PURPLE+"DEBUG"+ANSI_RESET+"] "+in);
    }
}