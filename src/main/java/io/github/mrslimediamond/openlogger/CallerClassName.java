package io.github.mrslimediamond.openlogger;

class CallerClassName {

    // Modified from https://stackoverflow.com/a/11306854
    private static StackTraceElement getCallerClassName0() {
        StackTraceElement[] stElements = Thread.currentThread().getStackTrace();
        String callerClassName = null;
        for (int i=1; i<stElements.length; i++) {
            StackTraceElement ste = stElements[i];
            if (!ste.getClassName().equals(CallerClassName.class.getName())
                    && !ste.getClassName().equals(OpenLogger.class.getName())
                    && !ste.getClassName().equals(Log.class.getName())
                    && !ste.getClassName().contains("java.lang.Thread")) {
                return ste;
            }
        }
        return null;
    }
    static String getFullCallerClassName() {
        return getCallerClassName0().getClassName();
    }
    static String getCallerClassName() {
        String result = getFullCallerClassName();
        if(result.contains(".")) {
            result = result.substring(result.lastIndexOf(".") + 1, result.length());
        }
        return result.replace("$", ".");
    }

    private CallerClassName() {
        throw new UnsupportedOperationException("CallerClassName cannot be initialized.");
    }
}
