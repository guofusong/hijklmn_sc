package edu.guosong.sc.hijklmndbserver.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.guosong.sc.hijklmncommon.dto.MenuDTO;
import edu.guosong.sc.hijklmncommon.po.Menu;
import edu.guosong.sc.hijklmndbserver.mapper.MenuMapper;
import edu.guosong.sc.hijklmndbserver.service.IMenuService;

@Service("menuService")
public class MenuServiceImpl implements IMenuService {

	@Resource
	private MenuMapper menuMapper;

	@Override
	public List<Menu> queryMenuList(MenuDTO menuDTO) {
		return menuMapper.queryList(menuDTO);
	}

}
