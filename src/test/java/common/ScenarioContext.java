package common;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    private static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal();
    private ScenarioContext() {
    }

    static {
        if (threadLocal.get() == null) {
            threadLocal.set(new HashMap<>());
        }
    }

    public enum Context {
        BOARD_ID,
        LIST_ID,
        CARD_ID
    }

    public static void setContext(Context key, Object value) {
        threadLocal.get().put(key.toString(), value);
    }

    public static Object getContext(Context key) {
        return threadLocal.get().get(key.toString());
    }

    public static Boolean Contains(Context key) {
        return threadLocal.get().containsKey(key.toString());
    }

}

