package com.honc.cqrs.cqrsall.copaconfig;

import com.alibaba.sofa.boot.Bootstrap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author honc.z
 * @date 2019/2/19
 *
 * copa框架启动配置文件
 */
@Configuration
public class SofaBootConfig {

    @Bean(initMethod = "init")
    public Bootstrap bootstrap(){
        List<String> list = new ArrayList<>();
        //当前包目录，为了扫描带有copa框架注解的类，例如@command
        list.add("com.honc");
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.setPackages(list);
        return bootstrap;
    }
}
