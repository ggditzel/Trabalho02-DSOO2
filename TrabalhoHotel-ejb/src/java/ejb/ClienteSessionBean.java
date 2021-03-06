/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author gustavo
 */
@Stateless
@LocalBean
public class ClienteSessionBean {

    @PersistenceContext(unitName = "TrabalhoHotel-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Metodo que retorna a lista de clientes armazenada na tabela Clientes
    public List<ejb.Clientes> getListaClientes() {
        Query query = em.createNamedQuery("Clientes.findAll");
        return query.getResultList();
    }
 
    public void cadastrarCliente(Clientes cliente) {  // Cadastra o cliente 
        em.persist(cliente);
    }
    
    public void salvarCliente(Clientes cliente) {
        em.merge(cliente);
        em.flush();
    }
    
    public void removerCliente(Long cpf) {
        em.remove(em.find(Clientes.class, cpf));
    }
    
    public Clientes editarCliente(Long cpf) {
        return em.find(Clientes.class, cpf);
    }
}
