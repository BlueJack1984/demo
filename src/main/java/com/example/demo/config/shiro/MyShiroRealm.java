package com.example.demo.config.shiro;

import com.example.demo.service.IShiroService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

/**
 * @desc 定义shiro权限框架的realm
 * @author lushusheng
 * @date 2018-11-21
 *
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    private IShiroService shiroService;

    /**
     * @desc 用户授权
     * @author lushusheng
     * @date 2018-11-21
     *
     */
    @Override protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        return authorizationInfo;
    }


    /**
     * @desc 用户登录认证
     * @author lushusheng
     * @date 2018-11-21
     *
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户输入的名称
        String userName = authenticationToken.getPrincipal().toString();
        String db_password = shiroService.getPasswordByUserName(userName);
        if(StringUtils.isEmpty(db_password)) {
            return null;
        }
        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userName,
                db_password, getName());
        return authenticationInfo;
    }
}
