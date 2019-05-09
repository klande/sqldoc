package com.sqldoc.soft.service.userDetail;


import com.sqldoc.soft.domain.UserInfo;
import com.sqldoc.soft.repository.UserInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	@Autowired
	private UserInfoRepository userInfoRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo user = userInfoRepository.findByUserAccount(username);
		if (null == user) {
			LOGGER.error("登录失败，用户名称 {} 不存在！",username);
			throw new UsernameNotFoundException("用户不存在！");
		}
		UserDetailsImpl userDetails = new UserDetailsImpl();
		BeanUtils.copyProperties(user, userDetails);
		userDetails.setPassword(user.getUserPassword());
		userDetails.setUsername(user.getUserAccount());
		return userDetails;
	}

}
