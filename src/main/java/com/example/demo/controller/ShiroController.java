package com.example.demo.controller;


import com.example.demo.model.response.OutputResult;
import com.example.demo.model.response.OutputResultCode;
import com.example.demo.service.IShiroService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @desc 测试shiro权限管理框架
 * 在Spring Boot2项目中整合Shiro主要分为四步
 *     1导入Shiro
 *     2创建Shiro配置文件，并在其中配置DefaultWebSecurityManager和ShiroFilterFactoryBean
 *     3实现身份认证的具体逻辑Realm
 *     4实现登录接口
 * @author lushusheng
 * @date 2018-11-22
 * @param
 * @return
 */
@RestController
@RequestMapping("/shiro")
public class ShiroController {

    @Autowired
    private IShiroService shiroService;
    /**
     * @desc 用户权限认证
     * @author lushusheng
     * @date 2018-11-22
     * @param userName 用户名称
     * @param password 用户密码
     * @return 返回认证结果
     */
    @GetMapping("/authorize")
    public OutputResult<Void> authorize(@RequestParam String userName, @RequestParam String password) {
        if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
            return new OutputResult<>(OutputResultCode.PARAMETER_ERROR.getCode(),
                    OutputResultCode.PARAMETER_ERROR.getMessage());
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        subject.login(token);
        return new OutputResult<>();
    }
}
