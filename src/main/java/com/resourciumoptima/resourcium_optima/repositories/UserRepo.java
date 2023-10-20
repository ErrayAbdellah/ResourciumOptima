package com.resourciumoptima.resourcium_optima.repositories;

import com.resourciumoptima.resourcium_optima.models.entities.User;

public interface UserRepo {
     void save(User user);
     void singIn(String email,String psw);
}
