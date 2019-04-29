package usecases;


import lombok.Getter;
import lombok.Setter;
import mybatis.dao.NetworkMapper;
import mybatis.model.Network;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class NetworksMyBatis {
    @Inject
    private NetworkMapper networkMapper;

    @Getter
    private List<Network> allNetworks;
    @Getter @Setter
    private Network networkToCreate = new Network();

    @PostConstruct
    public void init() {
        this.loadAllNetworks();
    }
    private void loadAllNetworks() {
        this.allNetworks = networkMapper.selectAll();
    }

    @Transactional
    public String createNetwork() {
        networkMapper.insert(networkToCreate);
        return "/myBatis/networks?faces-redirect=true";
    }


}
