package br.com.caelum.estoque.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.3.6
 * 2021-10-20T14:52:10.949-03:00
 * Generated source version: 3.3.6
 *
 */
@WebService(targetNamespace = "http://ws.estoque.caelum.com.br/", name = "EstoqueWS")
@XmlSeeAlso({ObjectFactory.class})
public interface EstoqueWS {

    @WebMethod(operationName = "TodosOsItens")
    @Action(input = "http://ws.estoque.caelum.com.br/EstoqueWS/TodosOsItensRequest", output = "http://ws.estoque.caelum.com.br/EstoqueWS/TodosOsItensResponse")
    @RequestWrapper(localName = "TodosOsItens", targetNamespace = "http://ws.estoque.caelum.com.br/", className = "br.com.caelum.estoque.ws.TodosOsItens")
    @ResponseWrapper(localName = "TodosOsItensResponse", targetNamespace = "http://ws.estoque.caelum.com.br/", className = "br.com.caelum.estoque.ws.TodosOsItensResponse")
    @WebResult(name = "itens", targetNamespace = "")
    public br.com.caelum.estoque.ws.ListaItens todosOsItens(

        @WebParam(name = "filtros", targetNamespace = "http://ws.estoque.caelum.com.br/")
        br.com.caelum.estoque.ws.Filtros filtros
    );

    @WebMethod(operationName = "CadastrarItem")
    @Action(input = "http://ws.estoque.caelum.com.br/EstoqueWS/CadastrarItemRequest", output = "http://ws.estoque.caelum.com.br/EstoqueWS/CadastrarItemResponse", fault = {@FaultAction(className = AutorizacaoFault.class, value = "http://ws.estoque.caelum.com.br/EstoqueWS/CadastrarItem/Fault/AutorizacaoException")})
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebResult(name = "CadastrarItemResponse", targetNamespace = "http://ws.estoque.caelum.com.br/", partName = "result")
    public CadastrarItemResponse cadastrarItem(

        @WebParam(partName = "parameters", name = "CadastrarItem", targetNamespace = "http://ws.estoque.caelum.com.br/")
        CadastrarItem parameters,
        @WebParam(partName = "tokenUsuario", name = "tokenUsuario", targetNamespace = "http://ws.estoque.caelum.com.br/", header = true)
        TokenUsuario tokenUsuario
    ) throws AutorizacaoFault;
}
