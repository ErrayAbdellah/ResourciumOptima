package com.resourciumoptima.resourcium_optima.repositories;

import com.resourciumoptima.resourcium_optima.models.entities.User;

public interface UserRepo {
     boolean save(User user);
     User singIn(String email,String psw);
     boolean update(User user);
}
