/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ejb.ServicoSessionBean;
import ejb.Servicos;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author gustavo
 */
@Named(value = "servicoManagedBean")
@RequestScoped
public class ServicoManagedBean {

    @EJB
    private ServicoSessionBean servicoSessionBean;

    private Servicos servico = new Servicos();  // Guarda os dados do formulário
    
    public ServicoManagedBean() {
    }

    public List<Servicos> getListaServicos() {
        return servicoSessionBean.getListaServicos();
    }
    
    public Servicos getServico() {
        return servico;
    }

    public void setServico(Servicos servico) {
        this.servico = servico;
    }

    public String cadastrarServico() {          // Chama o método do bean de sessão
        servicoSessionBean.cadastrarServico(servico);
        servico = new Servicos();
        return "index";
    }
    
    public String salvarServico() {
        servicoSessionBean.salvarServico(this.servico);
        return "index";
    }
    
    public String removerServico(int id) {
        servicoSessionBean.removerServico(id);
        return "index";
    }
    
}
