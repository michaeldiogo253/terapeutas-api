package br.com.michael.practicing.criteria.api.personas.terapeuta.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Entity
@NoArgsConstructor
public class DadosPessoais {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private long id;
	@Column(nullable = false) private String nomeCompleto;
	@Column(unique = true, nullable = false) private String cpf;
	@Column(unique = true, nullable = false) private String email;
	private LocalDate dataNascimento;
	@OneToOne(cascade = CascadeType.ALL) private Usuario usuario;

	public DadosPessoais(String nomeCompleto, String cpf, String email, LocalDate dataNascimento, Usuario usuario) {

		this.nomeCompleto = nomeCompleto;
		this.cpf = cpf;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.usuario = usuario;
	}
}
