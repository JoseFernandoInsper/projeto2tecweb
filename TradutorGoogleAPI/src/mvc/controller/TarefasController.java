package mvc.controller;

import java.sql.ResultSet;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import

org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rmtheis.yandtran.language.Language;
import com.rmtheis.yandtran.translate.Translate;

import mvc.model.Tarefa;
import mvc.model.TarefasDAO;
import mvc.model.Usuario;
import mvc.model.UsuarioDAO;

@Controller
public class TarefasController {

	@RequestMapping("criaTarefa")
	public String form() {
		return "formTarefa";
	}
	@RequestMapping("adicionaTarefa")
 	public String adiciona(Tarefa tarefa) {
	TarefasDAO dao = new TarefasDAO();
	dao.adicionaDescricao(tarefa);
	return "adicionada";
 }
	@RequestMapping(value="traduzir", method = RequestMethod.POST)
	public String feitaTrad(Tarefa tarefa, Usuario usuario, HttpSession session) throws Exception {
		TarefasDAO dao = new TarefasDAO();
		System.out.println("para traduzir  "+tarefa.getDescricao());
		Translate.setKey("trnsl.1.1.20190424T104812Z.20357d0f30134fbe.53335bdae02963c8d079eae12bd34dadfd5c63e0");
        String translatedText = Translate.execute(tarefa.getDescricao(), Language.PORTUGUESE, Language.ENGLISH);
        tarefa.setTraducao(translatedText);
        session.setAttribute("txttraduzido", tarefa.getTraducao());
        tarefa.setId_user(usuario.getLogin());
        System.out.println("usu" +usuario.getLogin());
        tarefa.setIdioma("ingles");
        dao.adicionaDescricao(tarefa);
        System.out.println(translatedText);
		return "formTarefa";
	}
}