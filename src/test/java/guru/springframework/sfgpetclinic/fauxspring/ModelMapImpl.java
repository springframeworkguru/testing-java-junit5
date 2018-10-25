package guru.springframework.sfgpetclinic.fauxspring;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jt on 2018-10-25.
 */
public class ModelMapImpl implements Model {
    Map<String, Object> map = new HashMap<>();

    @Override
    public void addAttribute(String key, Object o) {

        map.put(key, o);
    }

    @Override
    public void addAttribute(Object o) {
            // do nothing...
    }

    public Map<String, Object> getMap() {
        return map;
    }
}
