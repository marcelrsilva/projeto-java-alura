package br.com.casadocodigo.loja.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.dao.RoleDAO;
import br.com.casadocodigo.loja.dao.UsuarioDAO;
import br.com.casadocodigo.loja.models.Role;
import br.com.casadocodigo.loja.models.Usuario;
import br.com.casadocodigo.loja.validation.UsuarioValidation;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO usuarioDao;
	
	@Autowired
	private RoleDAO roleDao;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new UsuarioValidation());
	}	
	
	@RequestMapping("/form")
	public ModelAndView form(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("usuarios/form");
		modelAndView.addObject("usuarios", usuario); 		
		return modelAndView;
	}
	
	@RequestMapping(value="/form", method=RequestMethod.POST)
	@CacheEvict(value="usuariosHome", allEntries=true)
	public ModelAndView gravar(@Valid Usuario usuario, BindingResult result, 
				RedirectAttributes redirectAttributes){		
		
		if(result.hasErrors()) {
			return form(usuario);
		}		
				
		usuarioDao.gravar(usuario);		
		redirectAttributes.addFlashAttribute("sucesso", "Usuário cadastrado com sucesso!");		
		return new ModelAndView("redirect:/usuarios");
	}
	
	@RequestMapping( method=RequestMethod.GET)
	public ModelAndView listar() {
		List<Usuario> usuarios = usuarioDao.listar();
		ModelAndView modelAndView = new ModelAndView("usuarios/lista");
		modelAndView.addObject("usuarios", usuarios);
		return modelAndView;
	}
	

	@RequestMapping(value="/roles", method=RequestMethod.POST)	
	public ModelAndView gravarRoles(String email, RedirectAttributes redirectAttributes){
		Usuario usuario = usuarioDao.carregaUsuario(email);
		usuarioDao.gravar(usuario);
		redirectAttributes.addFlashAttribute("sucessorole", "Permissões alteradas com sucesso!");		
		return new ModelAndView("redirect:/usuarios");
	}

	@RequestMapping(value="/roles", method=RequestMethod.GET)
	public ModelAndView listarRoles(String email) {
		Usuario usuario = usuarioDao.loadUserByUsername(email);		
		ModelAndView modelAndView = new ModelAndView("usuarios/roles");		
		modelAndView.addObject("usuario", usuario);
		return modelAndView;
	}
}
