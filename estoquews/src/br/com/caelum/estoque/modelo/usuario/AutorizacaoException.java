package br.com.caelum.estoque.modelo.usuario;

import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.ws.WebFault;

import br.com.caelum.estoque.modelo.item.DateAdapter;

@WebFault(name = "AutorizacaoFault")
public class AutorizacaoException extends Exception {

	public AutorizacaoException(String mensagem) {
		super(mensagem);
	}
	
	
	public InfoFault getFaultInfo() {
		return new InfoFault("Token inv�lido", new Date());
	}

}
