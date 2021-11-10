package com.example.springbootbootstrap.services;

import com.example.springbootbootstrap.dao.RoleDao;
import com.example.springbootbootstrap.dao.RoleRepository;
import com.example.springbootbootstrap.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService{

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public List<Role> listRoles() {
        return roleRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteRole(int id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role getRole(int id) {
        Role role = null;
        Optional<Role> roleOptional = roleRepository.findById(id);
        if(roleOptional.isPresent()){
            role = roleOptional.get();
        }
        return role;
    }

    @Override
    public void updateRole(Role role) {
        roleRepository.save(role);
    }


    @Override
    public Role getRole(String name) {
        return roleRepository.findByRole(name);
    }
}
