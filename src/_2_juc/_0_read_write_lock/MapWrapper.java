package _2_juc._0_read_write_lock;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MapWrapper<K, V> implements Map<K, V> {
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock rLock = rwLock.readLock();
    private final Lock wLock = rwLock.writeLock();
    private final Map<K, V> m;

    public MapWrapper(Map<K, V> m) {
        this.m = m;
    }
    public static <K, V> Map<K, V> synchronizedMap(Map<K, V> m) {
        return new MapWrapper(m);
    }


    @Override
    public int size() {
        rLock.lock();
        try {
           return m.size();
        } finally {
            rLock.unlock();
        }
    }

    @Override
    public boolean isEmpty() {
        rLock.lock();
        try {
            return m.isEmpty();
        } finally {
            rLock.unlock();
        }
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        return null;
    }

    @Override
    public V put(K key, V value) {
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
