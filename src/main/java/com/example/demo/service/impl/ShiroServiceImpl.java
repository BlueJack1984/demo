package com.example.demo.service.impl;

import com.example.demo.service.IShiroService;
import org.springframework.stereotype.Service;

@Service
public class ShiroServiceImpl implements IShiroService {


    @Override
    public String getPasswordByUserName(String userName) {
        switch (userName){
            case "curry": return "303030";
            case "durant": return "353535";
            default: return null;
        }
    }
}
