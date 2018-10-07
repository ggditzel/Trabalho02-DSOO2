/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ejb.ClienteSessionBean;
import ejb.Clientes;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author gustavo
 */
@Named(value = "clienteManagedBean")
@RequestScoped
public class ClienteManagedBean {

    @EJB
    private ClienteSessionBean clienteSessionBean;
    
    private Clientes cliente = new Clientes();  // Guarda os dados do formulário

    /**
     * Creates a new instance of ClienteManagedBean
     */
    public ClienteManagedBean() {
    }
    
    public List<Clientes> getListaClientes() {
        return clienteSessionBean.getListaClientes();
    }
    
    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public String cadastrarCliente() {          // Chama o método do bean de sessão
        clienteSessionBean.cadastrarCliente(cliente);
        cliente = new Clientes();
        return "index";
    }
}
