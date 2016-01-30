package com.softdesign.school.utils;

import android.util.Log;

public class Lg {
    /**
     * Префикс добавляемый к сообщениям в логе
     */
    private static final String PREFIX = "SCHOOL ";
    /**
     * Максимальная длинна сообщения
     */
    public static final int LOGCAT_BUFFER_SIZE = 3000;

    private static boolean shouldLog() {
        //return BuildConfig.IS_LOGCAT_LOGGER_ENABLED;
        return true;
    }

    /**
     *Уровни приоритета сообщений INFO, ERROR, WARN, VERBOSE, DEBUG, ASSERT
     */
    public static void i (String tag, String text) { helper(Log.INFO, tag, text); }
    public static void e (String tag, String text) { helper(Log.ERROR, tag, text); }
    public static void w (String tag, String text) { helper(Log.WARN, tag, text); }
    public static void v (String tag, String text) { helper(Log.VERBOSE, tag, text); }
    public static void d (String tag, String text) { helper(Log.DEBUG, tag, text); }
    public static void a (String tag, String text) { helper(Log.ASSERT, tag, text); }

    /**
     * Метод для логирования
     * @param level - уровень приоритета лога
     * @param tag - тэг лога
     * @param text - текст лога
     */

    private static void helper(Integer level, String tag, String text) {
        if (shouldLog()) {
            String str = text;

            while (str.length() > LOGCAT_BUFFER_SIZE) {
                String substr = str.substring(0, LOGCAT_BUFFER_SIZE);
                str = substr.substring(LOGCAT_BUFFER_SIZE);
                Log.println(level, PREFIX + tag, substr);
            }

            Log.println(level, PREFIX + tag, str);
        }

    }
}
