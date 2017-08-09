package com.ych.core.ehcache;

import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;

/**
 * 缓存管理类
 *
 * @Created by: luole
 * @Date: 2016/9/18
 */
public class EhCacheCacheManagerExtended extends EhCacheCacheManager {

    /**
     * 重写，取新的缓存出来，
     * <p>系统初始化的时候执行</p>
     *
     * @param cache
     * @return
     */
    @Override
    protected Cache decorateCache(Cache cache) {
        return (isTransactionAware() ? new TransactionAwareCacheDecoratorExtended(cache) : cache);
    }
}
