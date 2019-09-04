package com.zjf.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    /**
     * 资源API
     * @return
     */
    @RequestMapping("/api/userinfo")
    public ResponseEntity<UserInfo> getUserInfo() {
//        User user = (User) SecurityContextHolder.getContext()
//                .getAuthentication().getPrincipal();
//        String email = user.getUsername() + "@harry.com";
        String user = (String)SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        String email = user + "@harry.com";
        UserInfo userInfo = new UserInfo();
        userInfo.setName(user);
        userInfo.setEmail(email);

        return ResponseEntity.ok(userInfo);
    }

    @RequestMapping("/api/user")
    public ResponseEntity<Authentication> getUser() {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();

        return ResponseEntity.ok(authentication);
    }

}