package com.sqldoc.soft.domain;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 用户信息表
 *
 * @author xiaodong-java
 */
@Entity
@Table(name = "sqldoc_user_info")
@Data
public class UserInfo extends AbstractEntity {

    private static final long serialVersionUID = -3814269000467386912L;

    @Column(unique = true, nullable = false, length = 20)
    private String userAccount;// 账户名称

    @Column(nullable = false, length = 100)
    private String userPassword;// 账户密码
}
