package com.ych.core.ehcache;

import org.springframework.cache.Cache;
import org.springframework.cache.transaction.TransactionAwareCacheDecorator;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * 处理EHCACHE放入缓存的时候不走原来的事务缓存
 *
 * @Created by: luole
 * @Date: 2016/9/18
 */
public class TransactionAwareCacheDecoratorExtended extends TransactionAwareCacheDecorator {

    private final Cache targetCache;

    /**
     * 构造方法
     *
     * @param targetCache
     *         the target Cache to decorate
     */
    public TransactionAwareCacheDecoratorExtended(Cache targetCache) {
        super(targetCache);
        this.targetCache = targetCache;
    }

    /**
     * 重写方法，PUT到EHCACHE中不管事务如何
     *
     * @param key
     * @param value
     */
    @Override
    public void put(final Object key, final Object value) {
        this.targetCache.put(key, value);
    }

    @Override
    public void evict(final Object key) {
        if (TransactionSynchronizationManager.isSynchronizationActive()) {
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
                @Override
                public void afterCommit() {
                    TransactionAwareCacheDecoratorExtended.this.targetCache.evict(key);
                }
            });
        }

        this.targetCache.evict(key);
    }
}
