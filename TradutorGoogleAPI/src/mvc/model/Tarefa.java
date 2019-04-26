package mvc.model;

import java.util.Calendar;

public class Tarefa {
	
	private Long id;
	private String descricao;
	private String id_user;
	private Calendar dataFinalizacao;
	private String idioma;
	private String traducao;
	
	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	
	public String getDescricao() {return descricao;}
	public void setDescricao(String descricao) {this.descricao = descricao;}

	public String getIdioma() {return idioma;}
	public void setIdioma(String idioma) {this.idioma = idioma;}
	
	public String getTraducao() {return traducao;}
	public void setTraducao(String traducao) {this.traducao = traducao;}
	
	public Calendar getDataFinalizacao() {return dataFinalizacao;}
	public void setDataFinalizacao(Calendar dataFinal) {this.dataFinalizacao = dataFinal;}
	
	public int getId_user() {
		return id_user;
	}
	public void setId_user(String id_user) {
		this.id_user = id_user;
	}
}
