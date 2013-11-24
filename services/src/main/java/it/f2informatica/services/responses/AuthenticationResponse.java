package it.f2informatica.services.responses;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@ToString
public class AuthenticationResponse implements Serializable {

	private String username;

	private String password;

	private String authorization;

}
