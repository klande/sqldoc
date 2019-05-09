package com.sqldoc.soft.repository;


import com.sqldoc.soft.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserInfoRepository extends PagingAndSortingRepository<UserInfo, String>, JpaSpecificationExecutor<UserInfo> {

    /**
     * 根据用户名称查找用户
     *
     * @param userAccount
     * @return
     * @author xiaodong-java
     * @date 2016年7月4日
     */
    UserInfo findByUserAccount(String userAccount);
}
