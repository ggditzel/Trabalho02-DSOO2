/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ejb.Clientes;
import ejb.QuartoSessionBean;
import ejb.Quartos;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author gustavo
 */
@Named(value = "quartoManagedBean")
@RequestScoped
public class QuartoManagedBean {

    @EJB
    private QuartoSessionBean quartoSessionBean;
    
    private Quartos quarto = new Quartos();  // Guarda os dados do formulário

    /**
     * Creates a new instance of QuartoManagedBean
     */
    public QuartoManagedBean() {
    }
    
    public List<Quartos> getListaQuartos() {
        return quartoSessionBean.getListaQuartos();
    }
    
    public Quartos getQuartos() {
        return quarto;
    }

    public void setQuartos(Quartos quarto) {
        this.quarto = quarto;
    }

    public String cadastrarQuarto() {          // Chama o método do bean de sessão
        quartoSessionBean.cadastrarQuarto(quarto);
        quarto = new Quartos();
        return "index";
    }
    
    public String salvarQuarto() {
        quartoSessionBean.salvarQuarto(this.quarto);
        return "index";
    }
    
    public String removerQuarto(int numero) {
        quartoSessionBean.removerQuarto(numero);
        return "index";
    }
    
}
