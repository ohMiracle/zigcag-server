package com.zigcag.rbac.service.impl;

import com.zigcag.rbac.dao.MenuDao;
import com.zigcag.rbac.model.Menu;
import com.zigcag.rbac.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Author: zhengchang
 * @Date: 2020/9/9
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    MenuDao menuDao;
    @Override
    public List<Menu> getMenuListByRoleId(String roleId) {
        return menuDao.getMenuListByRoleId(roleId);
    }

}
