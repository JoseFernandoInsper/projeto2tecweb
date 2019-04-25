package mvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mvc.model.Usuario;
import mvc.model.UsuarioDAO;

@Controller
public class LoginController {
	
	@RequestMapping("registro")
	public String registro() {
		return "formulario-registro";
	}
	
	@RequestMapping("/")
	public String login() {
		return "formulario-login";
	}
	
	@RequestMapping("loginForm")
	public String loginForm() {
		return "formulario-login";
	}
	
	@RequestMapping(value = "efetuaRegistro", method = RequestMethod.POST)
	public String upload(Usuario usuario) throws IOException {
		UsuarioDAO dao = new UsuarioDAO();
		System.out.println("controller" + usuario.getLogin());
		dao.adiciona(usuario);
		return "redirect:loginForm";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:loginForm";
	}
	
	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session) {
		if(new UsuarioDAO().existeUsuario(usuario)) {
			System.out.println("teste");
			session.setAttribute("usuarioLogado", usuario.getLogin());
			return "menu";
		}
		return "redirect:loginForm";
	}

}
