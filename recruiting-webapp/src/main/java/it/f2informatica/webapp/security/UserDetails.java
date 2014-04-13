package it.f2informatica.webapp.security;

import it.f2informatica.core.model.AuthenticationModel;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UserDetails extends org.springframework.security.core.userdetails.User {
  private static final long serialVersionUID = 2966265760964437674L;

  public UserDetails(AuthenticationModel userLogged, Collection<GrantedAuthority> authorities) {
    super(userLogged.getUsername(), userLogged.getPassword(), authorities);
  }

}
