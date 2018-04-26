/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

//import br.edu.ifsul.correio.CResultado;
//import br.edu.ifsul.correio.CalcPrecoPrazoWS;
import br.edu.ifsul.dao.PessoaDAO;
import br.edu.ifsul.servico.Pessoa;
import java.io.Serializable;
//import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Matheus
 */
@Named(value = "controlePessoa")
@SessionScoped
public class ControlePessoa implements Serializable {

    private Pessoa objeto;
    @EJB
    private PessoaDAO dao;
    //private CalcPrecoPrazoWS correios;

    public ControlePessoa() {

    }

    public String novo() {
        objeto = new Pessoa();
        objeto.setId(0);
        return "form";
    }

    public String alterar(Pessoa obj) {
        objeto = obj;
        return "form";
    }

    public String salvar() {
        if (objeto.getId() == 0) {
            dao.inserir(objeto);
        } else {
            dao.alterar(objeto);
        }
        return "index";
    }

    public void remover(Integer id) {
        dao.remover(id);
    }

    public Pessoa getObjeto() {
        return objeto;
    }

    public void setObjeto(Pessoa objeto) {
        this.objeto = objeto;
    }

    public PessoaDAO getDao() {
        return dao;
    }

    public void setDao(PessoaDAO dao) {
        this.dao = dao;
    }

    /*public String calcular(Pessoa obj) {
        CResultado res = correios.getCalcPrecoPrazoWSSoap()
                .calcPreco("", "", "04014", objeto.getCepOrigem(), objeto.getCepDestino(),
                        "20", //PESO MIN 20
                        1, // 1 CAIXA, 2 ROLO PRISMA; 3 ENVELOPE
                        new BigDecimal(20), //COMPRIMENTO MIN 16
                        new BigDecimal(20), //ALTURA MIN 20
                        new BigDecimal(20), //LARGURA MIN 11
                        new BigDecimal(20), //DIAMETRO MIN 20
                        "N", //SERVIÇO ADICIONAL MÃO PRÓPRIA
                        new BigDecimal("0"), // VALOR DECLARADO ??
                        "N"); //SERVIÇO AVISO DE RECEBIMENTO S/N
        
        obj.setValorFrete(Double.parseDouble(res.getServicos().getCServico().get(0).getValor()));
        obj.setPrazoEntrega(res.getServicos().getCServico().get(0).getPrazoEntrega());
        
        dao.alterar(obj);
        
        return "index";

    }*/

}
