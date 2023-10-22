package com.resourciumoptima.resourcium_optima.services;

import com.resourciumoptima.resourcium_optima.enums.Role;
import com.resourciumoptima.resourcium_optima.models.entities.User;
import com.resourciumoptima.resourcium_optima.repositories.UserRepo;
import com.resourciumoptima.resourcium_optima.repositories.impl.UserRepoImpl;
import org.mindrot.jbcrypt.BCrypt;

public class UserServiceImpl implements IUserService {
    private final UserRepo userRepo;
    public UserServiceImpl(){
        this.userRepo = new UserRepoImpl();
    }

    @Override
    public String saveUser(User user,String cnfPassword) {
        user.setRole(Role.ADMIN);
        if (cnfPassword == user.getPassword())
        {
            user.setPassword(hashPassword(user.getPassword()));
            if (userRepo.save(user)){
                return "user is saved";
            }
            return "error : user not saved ";
        }
            return "error : user not saved" ;
    }

    @Override
    public User singIn(String email, String psw) {
        return null;
    }
    public String hashPassword(String password) {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        return hashedPassword;
    }
}
