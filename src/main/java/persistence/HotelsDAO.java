package persistence;
import entities.Hotel;
import entities.Client;
import entities.Network;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class HotelsDAO {
    @Inject
    private EntityManager em;
    public List<Hotel> loadAll() {
        return em.createNamedQuery("Hotel.findAll", Hotel.class).getResultList();
    }

    public void persist(Hotel hotel){
        this.em.persist(hotel);
    }
    public Hotel findOne(Integer id) {
        return em.find(Hotel.class, id);
    }
}

