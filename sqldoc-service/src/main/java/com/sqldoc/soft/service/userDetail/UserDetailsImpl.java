package com.sqldoc.soft.service.userDetail;

import com.sqldoc.soft.domain.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class UserDetailsImpl extends UserInfo implements UserDetails {

    private static final long serialVersionUID = 8054364931337957594L;

    private String username;
    private String password;
    private String openId;
    private Map<String, Object> transitData = new HashMap<String, Object>();
    private Long unionUserId;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Map<String, Object> getTransitData() {
        return transitData;
    }

    public void setTransitData(Map<String, Object> transitData) {
        this.transitData = transitData;
    }

    public Long getUnionUserId() {
        return unionUserId;
    }

    public void setUnionUserId(Long unionUserId) {
        this.unionUserId = unionUserId;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
