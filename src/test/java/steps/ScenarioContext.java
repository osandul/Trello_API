package steps;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

//    private static ThreadLocal threadLocal = new ThreadLocal();
//    ThreadLocal () {
//        if (threadLocal == null) {
//            threadLocal = new ThreadLocal();
//        }
//        return threadLocal;
//    }

    private Map<String, Object> scenarioContext;

    public enum Context {
        BOARD_ID,
        BOARD_NAME
    }

    public ScenarioContext() {
        scenarioContext = new HashMap<>();
    }

    public void setContext(Context key, Object value) {
        scenarioContext.put(key.toString(), value);
    }

    public Object getContext(Context key) {
        return scenarioContext.get(key.toString());
    }

    public Boolean isContains(Context key) {
        return scenarioContext.containsKey(key.toString());
    }

}
}
