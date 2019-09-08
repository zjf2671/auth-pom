package com.zjf.client.api;

import com.zjf.common.security.service.AuthUser;
import com.zjf.common.security.util.SecurityUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.util.OAuth2Utils;
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
        String user = (String)SecurityUtils.getAuthentication().getPrincipal();
        String email = user + "@harry.com";
        UserInfo userInfo = new UserInfo();
        userInfo.setName(user);
        userInfo.setEmail(email);

        return ResponseEntity.ok(userInfo);
    }

    @RequestMapping("/api/user")
    public ResponseEntity<AuthUser> getUser() {
        AuthUser authUser = SecurityUtils.getUser();

        return ResponseEntity.ok(authUser);
    }

    @RequestMapping("/api/authentication")
    public ResponseEntity<Authentication> getAuthentication() {
        Authentication authentication = SecurityUtils.getAuthentication();

        return ResponseEntity.ok(authentication);
    }

    @RequestMapping("/message")
    public ResponseEntity<String> getMessage() {
        return ResponseEntity.ok("无需鉴权URL通过");
    }

}