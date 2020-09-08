package com.zigcag.rbac.service.impl;

import com.zigcag.rbac.dao.OperationDao;
import com.zigcag.rbac.service.OperationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @Description:
 * @Author: zhengchang
 * @Date: 2020/9/9
 */
@Service
public class OperationServiceImpl implements OperationService {
    @Resource
    OperationDao operationDao;
    @Override
    public Set<String> getOperationListByRoleId(String roleId) {
        return operationDao.getOperationListByRoleId(roleId);
    }
}
