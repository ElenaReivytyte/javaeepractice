package persistence;
import entities.Network;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.inject.Inject;

@ApplicationScoped

public class NetworksDAO {
    @Inject
    private EntityManager em;

    public List<Network> loadAll() {
        return em.createNamedQuery("Network.findAll", Network.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Network network){
        this.em.persist(network);
    }

    public Network findOne(Integer id) {
        return em.find(Network.class, id);
    }
}
