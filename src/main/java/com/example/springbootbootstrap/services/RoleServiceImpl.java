package com.example.springbootbootstrap.services;

import com.example.springbootbootstrap.dao.RoleDao;
import com.example.springbootbootstrap.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    private RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao){
        this.roleDao = roleDao;
    }

    @Override
    @Transactional
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public List<Role> getRolesList() {
        return roleDao.getRolesList();
    }

    @Override
    @Transactional
    public void deleteRole(int id) {
        roleDao.deleteRole(id);
    }

    @Override
    public Role getRole(int id) {
        return roleDao.getRole(id);
    }

    @Override
    @Transactional
    public void updateRole(Role role) {
        roleDao.updateRole(role);
    }

    @Override
    public Role getRole(String name) {
        return roleDao.getRole(name);
    }
}
