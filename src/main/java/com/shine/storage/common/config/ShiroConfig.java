package com.shine.storage.common.config;

import com.shine.storage.dao.entity.MyShiroRealm;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author : shine
 * @Project: Storage
 * @Description: shiro登录认证和权限管理配置
 * @date: 2018年10月14日 14:38
 */
@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //    拦截器
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        //    配置不被拦截的链接，顺序执行
        filterChainDefinitionMap.put("/api/test/**", "anon");
        //    配置推出过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "logout");
        //    需要认证才能执行的链接
        filterChainDefinitionMap.put("/api/**", "authc");

        //    如果没设置默认跳转到登录页面
        shiroFilterFactoryBean.setLoginUrl("/login.html");
        //    登录成功后跳转的页面
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //    未授权页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }


    @Bean
    public MyShiroRealm myShiroRealm() {
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        return myShiroRealm;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }
}
