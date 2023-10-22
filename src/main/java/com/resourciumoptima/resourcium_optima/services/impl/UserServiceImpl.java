package com.resourciumoptima.resourcium_optima.services.impl;

import com.resourciumoptima.resourcium_optima.enums.Role;
import com.resourciumoptima.resourcium_optima.models.entities.User;
import com.resourciumoptima.resourcium_optima.repositories.UserRepo;
import com.resourciumoptima.resourcium_optima.repositories.impl.UserRepoImpl;
import com.resourciumoptima.resourcium_optima.services.IUserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;

public class UserServiceImpl implements IUserService {
    private final UserRepo userRepo;
    public UserServiceImpl(){
        this.userRepo = new UserRepoImpl();
    }

    @Override
    public String saveUser(User user, String cnfPassword, HttpServletRequest request, HttpServletResponse response) {
        user.setRole(Role.EMPLOYER.toString());
        try {
            System.out.println(cnfPassword);
            System.out.println(user.getPassword());
        if (user.getPassword().equals((cnfPassword)))
        {
            user.setPassword(hashPassword(user.getPassword()));
            if (userRepo.save(user)){
                response.sendRedirect("signIn.jsp");
                return "user is saved";
            }
            return "error : user not saved ";
       }
    }catch (Exception e){
            e.printStackTrace();
        }
            return "error : password incorrect" ;
    }

    @Override
    public void singIn(String email, String psw, HttpServletRequest request,HttpServletResponse response) {
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = null;
        User user = new User();
        user = userRepo.singIn(email,psw) ;
        try {
            if (user!=null){
                session.setAttribute("user",userRepo.singIn(email,psw));
                dispatcher = request.getRequestDispatcher("/dashboard/dashboard.jsp");
                dispatcher.forward(request,response);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(User newUser, HttpServletRequest request,HttpServletResponse response) {
        User user = new User();
        if (request.getSession().getAttribute("user")!=null){
            Object userObj = request.getSession().getAttribute("user");
            if (userObj instanceof User) {
                user = (User) userObj;
                newUser.setId(user.getId());
                userRepo.update(newUser);
            }
        }
    }

    public String hashPassword(String password) {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        return hashedPassword;
    }


}
