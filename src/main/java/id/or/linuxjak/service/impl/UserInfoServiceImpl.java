package id.or.linuxjak.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import id.or.linuxjak.domain.User;
import id.or.linuxjak.domain.UserInfo;
import id.or.linuxjak.service.UserInfoService;
import id.or.linuxjak.service.UserService;
import id.or.linuxjak.service.common.ServiceHelperImpl;
@Service("userInfoService")
@Transactional
public class UserInfoServiceImpl extends ServiceHelperImpl<UserInfo> implements UserInfoService{
	
}
