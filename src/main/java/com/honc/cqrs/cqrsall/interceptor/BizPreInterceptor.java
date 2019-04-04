package com.honc.cqrs.cqrsall.interceptor;

import com.alibaba.sofa.command.CommandInterceptorI;
import com.alibaba.sofa.command.PreInterceptor;
import com.alibaba.sofa.context.TenantContext;
import com.alibaba.sofa.dto.Command;
import com.alibaba.sofa.dto.Query;
import com.honc.cqrs.cqrsall.interceptor.mybatisconfig.DatabaseType;

/**
 * @author honc.z
 * @date 2018/11/19
 * 业务拓展点判断拦截器
 * 读写库判断器
 */
@PreInterceptor
public class BizPreInterceptor implements CommandInterceptorI {
    @Override
    public void preIntercept(Command command) {
        if (command.getBizCode() != null) {
            TenantContext.set("1", command.getBizCode());
        }

        if (command instanceof Query){
            //查询，走读库
            DatabaseContextHolder.setDatabaseType(DatabaseType.querydb);
        }else {
            //命令，走写库
            DatabaseContextHolder.setDatabaseType(DatabaseType.commanddb);
        }
    }
}
