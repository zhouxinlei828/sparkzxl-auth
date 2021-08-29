package com.github.sparkzxl.ids.application.service;

import com.fujieid.jap.core.cache.JapCache;
import com.github.sparkzxl.cache.template.GeneralCacheService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0.0
 * @date 2021-04-17 20:06
 * @since 1.0.0
 */
public class IdsCacheImpl implements JapCache {

    private GeneralCacheService generalCacheService;

    public void setGeneralCacheService(GeneralCacheService generalCacheService) {
        this.generalCacheService = generalCacheService;
    }

    /**
     * Set cache
     *
     * @param key   Cache key
     * @param value Cache value after serialization
     */
    @Override
    public void set(String key, Serializable value) {
        generalCacheService.set(key,value);
    }

    /**
     * Set the cache and specify the expiration time of the cache
     *
     * @param key     Cache key
     * @param value   Cache value after serialization
     * @param timeout The expiration time of the cache, in milliseconds
     */
    @Override
    public void set(String key, Serializable value, long timeout) {
        generalCacheService.set(key,value,timeout, TimeUnit.MILLISECONDS);
    }

    /**
     * Get cache value
     *
     * @param key Cache key
     * @return Cache value
     */
    @Override
    public Serializable get(String key) {
        return generalCacheService.get(key);
    }

    /**
     * Determine whether a key exists in the cache
     *
     * @param key Cache key
     * @return boolean
     */
    @Override
    public boolean containsKey(String key) {
        return generalCacheService.exists(key);
    }

    /**
     * Delete the key from the cache
     *
     * @param key Cache key
     */
    @Override
    public void removeKey(String key) {
        generalCacheService.remove(key);
    }
}
