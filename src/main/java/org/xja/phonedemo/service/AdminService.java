package org.xja.phonedemo.service;

import org.xja.phonedemo.domain.Admin;

public interface AdminService {
    public Admin login(String name, String pwd);
}
