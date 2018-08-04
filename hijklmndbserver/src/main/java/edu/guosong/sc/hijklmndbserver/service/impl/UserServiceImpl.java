package edu.guosong.sc.hijklmndbserver.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.guosong.sc.hijklmncommon.dto.UserDTO;
import edu.guosong.sc.hijklmncommon.po.User;
import edu.guosong.sc.hijklmndbserver.mapper.UserMapper;
import edu.guosong.sc.hijklmndbserver.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Resource
	private UserMapper userMapper;

	@Override
	public User queryUser(UserDTO userDTO) {
		return userMapper.query(userDTO);
	}

	@Override
	public int addUser(User user) {
		return userMapper.insert(user);
	}

	@Override
	public List<User> queryUserList(UserDTO userDTO) {
		return userMapper.queryList(userDTO);
	}

}
