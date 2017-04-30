package com.meiling.datavisual.service;

import com.meiling.datavisual.model.User;

/**
 * Created by Meiling on 2017/4/22.
 * Project Name:EasyNotesServer
 */
public interface IUserService {

    User userLogin(String params);

    String userRegister(String params);
}
