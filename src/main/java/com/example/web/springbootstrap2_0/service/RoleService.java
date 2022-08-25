package com.example.web.springbootstrap2_0.service;

import com.example.web.springbootstrap2_0.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    List<Role> findAll();
    void nawRole(Role role);
}
