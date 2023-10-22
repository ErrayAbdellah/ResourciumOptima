package com.resourciumoptima.resourcium_optima.controller;

import com.resourciumoptima.resourcium_optima.models.entities.User;
import com.resourciumoptima.resourcium_optima.services.IUserService;
import com.resourciumoptima.resourcium_optima.services.impl.UserServiceImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "signup" , urlPatterns = {"*.u"})
public class UserController extends HttpServlet {
    private final IUserService userService ;

    public UserController(){

        this.userService = new UserServiceImpl();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        User user = new User();
        String path = request.getServletPath();
        System.out.println(path);
        switch (path){
            case "/login/add.u":
                user.setName(request.getParameter("name"));
                user.setEmail( request.getParameter("email"));
                user.setPassword(request.getParameter("password"));
                user.setLastName(request.getParameter("lastName"));
                String cnfPassword = request.getParameter("passwordConfirm");
                userService.saveUser(user,cnfPassword,request,response);
                break;
            case "/login/signin.u":
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                userService.singIn(email,password,request,response);
                break;
            case "/dashboard/update.u":
                user.setName(request.getParameter("name"));
                user.setEmail(request.getParameter("email"));
                user.setLastName(request.getParameter("lastName"));
                userService.update(user,request,response);
                break;
        }
    }

}
