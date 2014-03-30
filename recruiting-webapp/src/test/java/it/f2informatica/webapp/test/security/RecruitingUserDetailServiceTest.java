package it.f2informatica.webapp.test.security;

import com.google.common.collect.Lists;
import it.f2informatica.services.authentication.Authority;
import it.f2informatica.services.authentication.AuthenticationService;
import it.f2informatica.services.responses.AuthenticationResponse;
import it.f2informatica.webapp.security.AuthorityService;
import it.f2informatica.webapp.security.RecruitingUserDetailService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RecruitingUserDetailServiceTest {

	@Mock
	private AuthenticationService authenticationService;

	@Mock
	private AuthorityService authorityService;

	private UserDetails userAuthenticated;

	@Before
	public void setUp() {
		UserDetailsService userDetailsService = new RecruitingUserDetailService();
		((RecruitingUserDetailService) userDetailsService).setAuthenticationService(authenticationService);
		((RecruitingUserDetailService) userDetailsService).setAuthorityService(authorityService);

		when(authenticationService.processLogin("username1")).thenReturn(createResponse());
		when(authorityService.createAuthorities("role_admin")).thenReturn(getGrantedAuthorities());
		userAuthenticated = userDetailsService.loadUserByUsername("username1");
	}

	@Test
	public void loadUserByUsername() {
		assertThat(userAuthenticated).isNotNull();
	}

	@Test
	public void testUserAuthenticatedUsername() {
		assertThat(userAuthenticated.getUsername()).isEqualTo("username1");
	}

	@Test
	public void testUserAuthenticatedPassword() {
		assertThat(userAuthenticated.getPassword()).isEqualTo("password1");
	}

	private List<GrantedAuthority> getGrantedAuthorities() {
		return Lists.<GrantedAuthority>newArrayList(
				new SimpleGrantedAuthority(Authority.ROLE_ADMIN.toString())
		);
	}

	private static AuthenticationResponse createResponse() {
		AuthenticationResponse authenticationResponse = new AuthenticationResponse();
		authenticationResponse.setUsername("username1");
		authenticationResponse.setPassword("password1");
		authenticationResponse.setAuthorization("role_admin");
		return authenticationResponse;
	}

}