package usecases;

import lombok.Getter;
import lombok.Setter;
import entities.Network;
import persistence.NetworksDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Networks {
    @Inject
    private NetworksDAO networksDAO;

    @Getter @Setter

    private Network networkToCreate = new Network();

    @Getter
    private List<Network> allNetworks;

    @PostConstruct
    public void init(){
        loadAllNetworks();
    }
    @Transactional
    public String createNetwork(){
        this.networksDAO.persist(networkToCreate);
        return "index?faces-redirect=true";
    }
    private void loadAllNetworks(){
        this.allNetworks = networksDAO.loadAll();
    }
}
