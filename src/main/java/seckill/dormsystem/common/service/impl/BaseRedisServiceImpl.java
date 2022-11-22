package seckill.dormsystem.common.service.impl;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import seckill.dormsystem.common.service.BaseRedisService;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseRedisServiceImpl implements BaseRedisService {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public <T> void set(String key, T value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public <T> void set(String key, T value, Integer timeout, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
    }

    @Override
    public Boolean expire(String key, Long timeout, TimeUnit timeUnit) {
        return redisTemplate.expire(key, timeout, timeUnit);
    }

    @Override
    public Boolean expire(String key, Long timeout) {
        return expire(key, timeout, TimeUnit.SECONDS);
    }

    @Override
    public Long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    @Override
    public Object get(String key) {
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        return operations.get(key);
    }

    @Override
    public Boolean delete(String key) {
        return redisTemplate.delete(key);
    }

    @Override
    public Long delete(Collection collection) {
        return redisTemplate.delete(collection);
    }

    @Override
    public Boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    @Override
    public Long incr(String key, long delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }

    @Override
    public Long decr(String key, long delta) {
        return redisTemplate.opsForValue().decrement(key, delta);
    }

    @Override
    public List<Object> listGet(String key) {
        return redisTemplate.opsForList().range(key, 0, -1);
    }

    @Override
    public List<Object> listRange(String key, long start, long end) {
        return redisTemplate.opsForList().range(key, start, end);
    }

    @Override
    public Long listSize(String key) {
        return redisTemplate.opsForList().size(key);
    }

    @Override
    public Object listIndex(String key, long index) {
        return redisTemplate.opsForList().index(key, index);
    }

    @Override
    public <T> Long listPush(String key, T value) {
        return redisTemplate.opsForList().rightPush(key, value);
    }

    @Override
    public <T> Long listPush(String key, T value, long time) {
        Long index = redisTemplate.opsForList().rightPush(key, value);
        expire(key, time);
        return index;

    }

    @Override
    public <T> Long listPushAll(String key, T... value) {
        return redisTemplate.opsForList().rightPushAll(key, value);
    }

    @Override
    public <T> Long listPushAll(String key, long time, T... value) {
        Long index = redisTemplate.opsForList().rightPushAll(key, value);
        expire(key, time);
        return null;
    }

    @Override
    public <T> Long listPushAll(String key, List<T> valueList) {
        return redisTemplate.opsForList().rightPushAll(key, valueList);
    }

    @Override
    public <T> Long listPushAll(String key, long time, List<T> valueList) {
        Long index = redisTemplate.opsForList().rightPushAll(key, valueList);
        expire(key, time);
        return null;
    }

    @Override
    public <T> Long listRemove(String key, long count, T value) {
        return redisTemplate.opsForList().remove(key, count, value);
    }
}
