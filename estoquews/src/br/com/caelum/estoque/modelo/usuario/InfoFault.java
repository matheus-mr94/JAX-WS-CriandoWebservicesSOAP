package br.com.caelum.estoque.modelo.usuario;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class InfoFault{
	
	private String mensagem;
	private Date dataErro;
	
	public InfoFault() {
		
	}

	public InfoFault(String mensagem, Date dataErro) {
		super();
		this.mensagem = mensagem;
		this.dataErro = dataErro;
	}
	
	

}
