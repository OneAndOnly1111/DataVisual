package com.meiling.datavisual.controller;

import com.meiling.datavisual.model.User;
import com.meiling.datavisual.service.IUserService;
import com.meiling.datavisual.utils.ResponseUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Meiling on 2017/4/22.
 * Project Name:EasyNotesServer
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService mUserServiceImpl;

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String userLogin(@RequestBody String params) {
        User user = mUserServiceImpl.userLogin(params);
        if (null == user) {
            return ResponseUtil.parseFailedRespJson("邮箱或密码错误");
        }
        user.setJointime(null);
        return ResponseUtil.parseSuccessRespJson(user);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String userRegister(@RequestBody String params) {
        return mUserServiceImpl.userRegister(params);
    }
}