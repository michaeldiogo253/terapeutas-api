package br.com.michael.practicing.criteria.api.personas.terapeuta.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor
public class Usuario {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
	private String login;
	private String password;

	public Usuario(String login, String password) {

		this.login = login;
		this.password = password;
	}
}
