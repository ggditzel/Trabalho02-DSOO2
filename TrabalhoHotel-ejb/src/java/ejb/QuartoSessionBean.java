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
public class QuartoSessionBean {

    @PersistenceContext(unitName = "TrabalhoHotel-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public List<ejb.Quartos> getListaQuartos() {
        Query query = em.createNamedQuery("Quartos.findAll");
        return query.getResultList();
    }
 
    public void cadastrarQuarto(Quartos quarto) {  // Cadastra o cliente 
        em.persist(quarto);
    }
    
    public void salvarQuarto(Quartos quarto) {
        em.merge(quarto);
        em.flush();
    }
    
    public void removerQuarto(int numero) {
        em.remove(em.find(Quartos.class, numero));
    }
    
}
