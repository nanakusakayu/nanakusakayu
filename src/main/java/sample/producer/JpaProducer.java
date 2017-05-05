package sample.producer;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tada
 */
@Dependent
public class JpaProducer {
    @PersistenceContext(unitName = "testPU")
    private EntityManager em;
    
    @Produces
    public EntityManager getEntityManager() {
        return em;
    }
}
