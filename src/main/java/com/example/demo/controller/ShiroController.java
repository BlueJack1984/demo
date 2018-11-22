package com.example.demo.controller;


import com.example.demo.model.response.OutputResult;
import com.example.demo.model.response.OutputResultCode;
import com.example.demo.service.IShiroService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @desc 测试shiro权限管理框架
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
     * @param
     * @return
     */
    @GetMapping("/authorize")
    public OutputResult<Void> authorize(@RequestParam String userName, @RequestParam String password) {
        if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
            return new OutputResult<>(OutputResultCode.PARAMETER_ERROR.getCode(),
                    OutputResultCode.PARAMETER_ERROR.getMessage());
        }
        String db_password = shiroService.getPasswordByUserName(userName);
        if(StringUtils.isEmpty(db_password) || !db_password.equals(password)) {
            return new OutputResult<>(OutputResultCode.UNAUTHORIZED.getCode(),
                    OutputResultCode.UNAUTHORIZED.getMessage());
        }
        return new OutputResult<>();
    }
}
