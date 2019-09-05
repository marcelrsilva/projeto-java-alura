package br.com.casadocodigo.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.fabric.xmlrpc.base.Array;

import br.com.casadocodigo.loja.models.Usuario;

@Repository
@Transactional
public class UsuarioDAO implements UserDetailsService {

	@PersistenceContext
	private EntityManager manager;

	private int emailEncontrado;

	public int getEmailEncontrado() { //serve para q?
		return emailEncontrado;
	}

	public void setEmailEncontrado(int emailEncontrado) { //serve para q?
		this.emailEncontrado = emailEncontrado;
	}

	public Usuario loadUserByUsername(String email) {
		List<Usuario> usuarios = manager.createQuery("select u from Usuario u where email = :email", Usuario.class)
				.setParameter("email", email).getResultList();

		if (usuarios.isEmpty()) {
			
			throw new UsernameNotFoundException("Usuario " + email + " não foi encontrado");
		}
	
		return usuarios.get(0);
	}

	public void gravar(Usuario usuario) {
		manager.persist(usuario);
	}

	public List<Usuario> listar() {
		return manager.createQuery("select distinct(u) from Usuario u", Usuario.class).getResultList();
	}
	
	public Usuario carregaUsuario(String email) {
		List<Usuario> usuarios = manager.createQuery("select u from Usuario u join fetch u.roles where email = :email", Usuario.class)
				.setParameter("email", email).getResultList();			
		return usuarios.get(0);
	}
	
	public Boolean checaEmail(String email) {
		Boolean check = manager.contains(email);
		return check;
	}
	
	
}

