package com.resourciumoptima.resourcium_optima.services;

import com.resourciumoptima.resourcium_optima.models.entities.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface IUserService {
    String saveUser(User user , String cnfPassword, HttpServletRequest request , HttpServletResponse response);
    void singIn(String email,String psw,HttpServletRequest request,HttpServletResponse response);
    void update(User user, HttpServletRequest request,HttpServletResponse response);
}
