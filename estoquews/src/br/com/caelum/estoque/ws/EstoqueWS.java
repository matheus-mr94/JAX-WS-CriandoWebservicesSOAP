package br.com.caelum.estoque.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.caelum.estoque.modelo.item.Filtro;
import br.com.caelum.estoque.modelo.item.Filtros;
import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;
import br.com.caelum.estoque.modelo.item.ItemValidador;
import br.com.caelum.estoque.modelo.item.ListaItens;
import br.com.caelum.estoque.modelo.usuario.AutorizacaoException;
import br.com.caelum.estoque.modelo.usuario.TokenDao;
import br.com.caelum.estoque.modelo.usuario.TokenUsuario;

@WebService
public class EstoqueWS {

	private ItemDao itemDao = new ItemDao();

	@WebMethod(operationName = "TodosOsItens")
	@WebResult(name = "Itens")
	public ListaItens getItens(@WebParam(name = "filtros") Filtros filtros) {
		System.out.println("Chamando getItens()");

		List<Filtro> listaFiltros = filtros.getLista();
		List<Item> lista = itemDao.todosItens(listaFiltros);

		return new ListaItens(lista);
	}

	@WebMethod(operationName = "CadastrarItem")
	@WebResult(name = "Item")
	public Item cadastrarItem(
			@WebParam(name = "token", header = true) TokenUsuario token,
			@WebParam(name = "item") Item item) 
					throws AutorizacaoException {

		System.out.println("Cadastrando item");

		boolean valido = new TokenDao().ehValido(token);

		if (!valido) {
			throw new AutorizacaoException("Autorização falhou");
		}
		
		new ItemValidador(item).validate();
		this.itemDao.cadastrar(item);

		return item;
	}
}
