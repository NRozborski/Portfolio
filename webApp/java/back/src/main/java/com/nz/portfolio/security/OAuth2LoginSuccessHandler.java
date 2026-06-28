package com.nz.portfolio.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.nz.portfolio.service.UserService;

import io.jsonwebtoken.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class OAuth2LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

  private final UserService userService;

  public OAuth2LoginSuccessHandler(UserService userService) {
      super("/dashboard");
      this.userService = userService;
  }

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request,
          HttpServletResponse response, Authentication authentication)
          throws IOException, ServletException {
      OidcUser oidcUser = (OidcUser) authentication.getPrincipal();
      userService.saveOrUpdate(oidcUser.getEmail(), oidcUser.getAttribute("name"));
      try{
          super.onAuthenticationSuccess(request, response, authentication);
      } catch (Exception e) {
          System.out.println("oopsie");
      }
      //TODO handling of IOException
  }
}