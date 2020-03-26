package com.lee.demo.web.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author LCQ
 */
@Configuration
public class ShiroConfig {

    @Bean
    public SecurityManager securityManager(MyRealm realm){
        DefaultWebSecurityManager securityManager= new DefaultWebSecurityManager();
        //设置使用的密码匹配器   不设置默认为SimpleCredentialsMatcher
        realm.setCredentialsMatcher(hashedCredentialsMatcher());
        securityManager.setRealm(realm);
        return securityManager;
    }

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        //设置散列算法
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        //设置散列迭代次数
        hashedCredentialsMatcher.setHashIterations(2);
        //使用hex编码时置为true,使用Base64时置为false    不设置时默认为true
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(false);
        return hashedCredentialsMatcher;
    }

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setUnauthorizedUrl("/error");

        //过滤器链定义   按map中的顺序过滤
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();
        // <!-- authc:必须认证通过才可以访问;    anon:允许匿名访问-->
        filterChainDefinitionMap.put("/", "anon");
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/error", "anon");
        filterChainDefinitionMap.put("/user/register", "anon");
        filterChainDefinitionMap.put("/user/queryList", "anon");
        //这行代码必须放在所有权限设置的最后，不然会导致所有 url 都被拦截 都需要认证
        filterChainDefinitionMap.put("/**","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }
}
