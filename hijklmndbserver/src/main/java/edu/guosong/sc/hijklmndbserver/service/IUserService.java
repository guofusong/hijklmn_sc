package edu.guosong.sc.hijklmndbserver.service;

import java.util.List;

import edu.guosong.sc.hijklmncommon.dto.UserDTO;
import edu.guosong.sc.hijklmncommon.po.User;

public interface IUserService {

	User queryUser(UserDTO userDTO);

	List<User> queryUserList(UserDTO userDTO);

	int addUser(User user);

}
