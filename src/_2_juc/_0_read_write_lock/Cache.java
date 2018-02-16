package _2_juc._0_read_write_lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {
//    private Map<Integer, String> map = new Hashtable<>();
//    private Map<Integer, String> map = Collections.synchronizedMap(new HashMap<Integer, String>());
    private Map<Integer, String> map = new ConcurrentHashMap<>();

    public String get(Object key) {
        Map<Integer, String> hashMap = new HashMap<>();

        return map.get(key);
    }

    public String put(Integer key, String value) {
        return map.put(key, value);
    }
}
