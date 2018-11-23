package com.example.demo.config.shiro;


import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @desc 配置shiro权限管理框架
 * 在Spring Boot2项目中整合Shiro主要分为四步
 *     1导入Shiro
 *     2创建Shiro配置文件，并在其中配置DefaultWebSecurityManager和ShiroFilterFactoryBean
 *     3实现身份认证的具体逻辑Realm
 *     4实现登录接口
 * @author lushusheng
 * @date 2018-11-22
 */
@Configuration
public class ShiroConfig {

    /**
     * @desc 注入自定义的Realm
     * @author lushusheng
     * @date 2018-11-22
     */
    @Bean(name = "myShiroRealm")
    public MyShiroRealm myShiroRealm() {
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        return myShiroRealm;
    }

    /**
     * @desc 注入自定义的Realm到安全管理器并管理
     * @author lushusheng
     * @date 2018-11-22
     */
    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }

    /**
     * @desc 注入自定义的Realm到安全管理器中
     * @author lushusheng
     * @date 2018-11-22
     */
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        return shiroFilterFactoryBean;
    }
}
