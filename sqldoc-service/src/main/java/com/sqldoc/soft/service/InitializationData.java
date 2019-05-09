package com.sqldoc.soft.service;



import com.sqldoc.soft.repository.UserInfoRepository;
import com.sqldoc.soft.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitializationData {
    @Autowired
    private UserInfoRepository userInfoRepository;


    /**
     * 初始化用户信息
     */
    @PostConstruct
    public void initUserInfo() {
        if (userInfoRepository.count() <= 0) {
            UserInfo user = new UserInfo();
            user.setUserAccount("admin");
            user.setUserPassword("$2a$10$NYotGjUs0/eqEVHLxglt4.tnjDeByuQ9wWPNt/zIIgHWydVS65b7S");// 密码:admin
            userInfoRepository.save(user);
        }
    }


}
