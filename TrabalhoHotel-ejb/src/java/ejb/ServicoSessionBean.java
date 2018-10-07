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
public class ServicoSessionBean {

    @PersistenceContext(unitName = "TrabalhoHotel-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Metodo que retorna a lista de clientes armazenada na tabela Clientes
    public List<ejb.Servicos> getListaServicos() {
        Query query = em.createNamedQuery("Servicos.findAll");
        return query.getResultList();
    }
   
    public int getMaxId() {  // pega o maior ID de cliente na tabela
        Query query = em.createNativeQuery("SELECT MAX(id) FROM SERVICOS");
        return (Integer) query.getSingleResult();
}
 
    public void cadastrarServico(Servicos servico) {  // Cadastra o cliente 
        servico.setId(getMaxId()+1);
        em.persist(servico);
}
    
    public void salvarServico(Servicos servico) {
        em.merge(servico);
        em.flush();
    }
    
    public void removerServico(Integer id) {
        em.remove(em.find(Servicos.class, id));
    }
}
