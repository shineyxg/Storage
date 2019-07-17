package com.shine.storage.common.config.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author : shine
 * @Project: Storage
 * @Description:
 * @date: 2019年07月17日 23:26
 */
public class ShiroFilterMapFactory {

    public static Map<String, String> getShiroFilterMap() {

        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

        // 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/favicon.ico", "anon");
        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "logout");
        //<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        filterChainDefinitionMap.put("/druid/**", "anon");
        filterChainDefinitionMap.put("/api/person/**", "anon");
        filterChainDefinitionMap.put("/api/**", "anon");
        filterChainDefinitionMap.put("/swagger-ui.html", "anon");
        filterChainDefinitionMap.put("/swagger-resources/**", "anon");
        filterChainDefinitionMap.put("/v2/**", "anon");
        filterChainDefinitionMap.put("/webjars/springfox-swagger-ui/**", "anon");
        filterChainDefinitionMap.put("/bootstrap/**", "anon");
        filterChainDefinitionMap.put("/*.js", "anon");
        filterChainDefinitionMap.put("/logina", "anon");
        filterChainDefinitionMap.put("/**", "authc");

        return filterChainDefinitionMap;


    }
}
