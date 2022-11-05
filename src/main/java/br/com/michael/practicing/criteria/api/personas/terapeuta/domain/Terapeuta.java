package br.com.michael.practicing.criteria.api.personas.terapeuta.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Terapeuta {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
	@OneToOne(cascade = CascadeType.ALL) private DadosPessoais dadosPessoais;
	private String numeroRegistro;
	private String especializacao;

	public Terapeuta(DadosPessoais dadosPessoais, String numeroRegistro, String especializacao) {

		this.dadosPessoais = dadosPessoais;
		this.numeroRegistro = numeroRegistro;
		this.especializacao = especializacao;
	}
}
