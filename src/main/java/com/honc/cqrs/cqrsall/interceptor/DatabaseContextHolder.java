package com.honc.cqrs.cqrsall.interceptor;

import com.honc.cqrs.cqrsall.interceptor.mybatisconfig.DatabaseType;

/**
 * @author honc.z
 * @date 2019/4/3
 * <p>
 * 线程安全的datebase容器
 * threadlocal实现
 */
public class DatabaseContextHolder {
    private static final ThreadLocal<DatabaseType> contextHolder = new ThreadLocal<>();

    public static void setDatabaseType(DatabaseType type) {
        contextHolder.set(type);
    }

    public static DatabaseType getDatabaseType() {
        return contextHolder.get();
    }
}
