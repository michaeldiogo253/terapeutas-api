package br.com.michael.practicing.criteria.api.personas.terapeuta.service;

import br.com.michael.practicing.criteria.api.personas.terapeuta.domain.Terapeuta;
import br.com.michael.practicing.criteria.api.personas.terapeuta.repository.TerapeutaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarTerapeutasService {

	private final TerapeutaRepository terapeutaRepository;
	private final EntityManager entityManager;

	public List<Terapeuta> execute( String nome, String cpf, String email, String login, String especializacao, List<Long> idsTerapeutas){

		String jpql = "SELECT t FROM Terapeuta t " +
		              "JOIN DadosPessoais d on d = t.dadosPessoais " +
		              "JOIN Usuario u on u = d.usuario " +
		              "WHERE 1 = 1 ";

		if(nome != null && !nome.trim().isEmpty()){
			jpql += " AND lower(d.nomeCompleto) LIKE lower(CONCAT('%',:nome,'%')) ";
		}

		if(cpf != null && !cpf.trim().isEmpty()){
			jpql += " AND d.cpf LIKE CONCAT('%',:cpf,'%') ";
		}

		if(email != null && !email.trim().isEmpty()){
			jpql += " AND lower(d.email) LIKE lower(CONCAT('%',:email,'%')) ";
		}

		if(login != null && !login.trim().isEmpty()){
			jpql += " AND u.login LIKE CONCAT('%',:login,'%') ";
		}

		if(especializacao != null && !especializacao.trim().isEmpty()){
			jpql += " AND lower(t.especializacao) LIKE lower(CONCAT('%',:especializacao,'%')) ";
		}

		if (!idsTerapeutas.isEmpty()){
			jpql += " AND t.id IN :idsTerapeutas ";
		}


		TypedQuery<Terapeuta> query = entityManager.createQuery(jpql, Terapeuta.class);

		if(nome != null && !nome.trim().isEmpty()){
			query.setParameter("nome", nome);
		}

		if(cpf != null && !cpf.trim().isEmpty()){
			query.setParameter("cpf", cpf);
		}

		if(email != null && !email.trim().isEmpty()){
			query.setParameter("email", email);
		}

		if(login != null && !login.trim().isEmpty()){
			query.setParameter("login", login);
		}

		if(especializacao != null && !especializacao.trim().isEmpty()){
			query.setParameter("especializacao", especializacao);
		}

		if(!idsTerapeutas.isEmpty()){
			query.setParameter("idsTerapeutas", idsTerapeutas);
		}

		return query.getResultList();

	}

}
