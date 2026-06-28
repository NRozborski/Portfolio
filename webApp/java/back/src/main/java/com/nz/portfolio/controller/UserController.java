package com.nz.portfolio.controller;

import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/dashboard")
    public Map<String, Object> dashboard(@AuthenticationPrincipal OidcUser user) {
        return Map.of(
            "name",    user.getAttribute("name"),
            "email",   user.getAttribute("email"),
            "picture", user.getAttribute("picture")
        );
    }
}