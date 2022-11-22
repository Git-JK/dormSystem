package seckill.dormsystem.common.service;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

public interface BaseRedisService {
    /**
     * 缓存基本对象，Integer、String、实体类等
     * @param key 缓存的键值
     * @param value 缓存的值
     * @param <T>
     */
    <T> void set(String key, T value);

    /**
     * 缓存基本对象，Integer，String，实体类等
     * @param key 缓存的键值
     * @param value 缓存的值
     * @param timeout 时间
     * @param timeUnit 时间颗粒度
     * @param <T>
     */
    <T> void set(String key, T value, Integer timeout, TimeUnit timeUnit);

    /**
     * 设置有效时间
     * @param key redis key
     * @param timeout 超时时间
     * @param timeUnit 时间单位
     * @return true设置成功，false设置失败
     */
    Boolean expire(String key, Long timeout, TimeUnit timeUnit);

    /**
     * 设置有效时间
     * @param key redis key
     * @param timeout 超时时间
     * @return true设置成功，false设置失败
     */
    Boolean expire(String key, Long timeout);

    /**
     * 获得过期时间
     * @param key redis key
     * @return 过期时间
     */
    Long getExpire(String key);

    /**
     * 获得缓存的基本对象
     * @param key 缓存key
     * @return 缓存key对应的数据
     */
    Object get(String key);

    /**
     * 删除单个对象
     * @param key
     * @return
     */
    Boolean delete(String key);

    /**
     * 删除集合对象
     * @param collection 多个对象
     * @return
     */
    Long delete(Collection collection);

    /**
     * 判断是否含有key
     * @param key redis key
     * @return
     */
    Boolean hasKey(String key);

    /**
     * 按delta递增
     * @param key redis key
     * @param delta
     * @return
     */
    Long incr(String key, long delta);

    /**
     * 按delta递减
     * @param key redis key
     * @param delta
     * @return
     */
    Long decr(String key, long delta);

    /**
     * 获得整个list
     * @param key
     * @return
     */
    List<Object> listGet(String key);

    /**
     * 获得范围内list数据
     * @param key
     * @param start
     * @param end
     * @return
     */
    List<Object> listRange(String key, long start, long end);

    /**
     * 获得list长度
     * @param key
     * @return
     */
    Long listSize(String key);

    /**
     * 根据index获得list中属性
     * @param key
     * @param index
     * @return
     */
    Object listIndex(String key, long index);

    /**
     * 在list右边插入新的值
     * @param key
     * @param value
     * @return
     * @param <T>
     */
    <T> Long listPush(String key, T value);

    /**
     * 在list右边插入新的值，并刷新list的过期时间
     * @param key
     * @param value
     * @param time
     * @return
     * @param <T>
     */
    <T> Long listPush(String key, T value, long time);

    /**
     * 在list右边插入多个新的值，个数不定
     * @param key
     * @param value
     * @return
     * @param <T>
     */
    <T> Long listPushAll(String key, T... value);

    /**
     * 在list右边插入多个新的值，个数不定，并设置过期时间
     * @param key
     * @param time
     * @param value
     * @return
     * @param <T>
     */
    <T> Long listPushAll(String key, long time, T... value);

    /**
     * 在list右边插入一个List
     * @param key
     * @param valueList
     * @return
     * @param <T>
     */
    <T> Long listPushAll(String key, List<T> valueList);

    /**
     * 在list右边插入一个List并设置过期时间
     * @param key
     * @param valueList
     * @param time
     * @return
     * @param <T>
     */
    <T> Long listPushAll(String key, long time, List<T> valueList);

    /**
     * 删除list中值为value的元素
     * @param key
     * @param count count > 0则删除从左到右的第一个元素，count < 0则删除从右到左的第一个元素，count == 0则删除所有等于value的元素
     * @param value
     * @return
     * @param <T>
     */
    <T> Long listRemove(String key, long count, T value);
}
