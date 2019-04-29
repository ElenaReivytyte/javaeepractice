package usecases;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

import entities.Network;
import persistence.NetworksDAO;
import entities.Hotel;
import persistence.HotelsDAO;
import javax.transaction.Transactional;

@Model
public class HotelsForNetwork implements Serializable {

    @Inject
    private NetworksDAO networksDAO;

    @Inject
    private HotelsDAO hotelsDAO;

    @Getter @Setter
    private Network network;
    @Getter @Setter
    private Hotel hotelToCreate = new Hotel();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer networkId = Integer.parseInt(requestParameters.get("networkId"));
        this.network = networksDAO.findOne(networkId);
    }
    @Transactional
    public String createHotel() {
        hotelToCreate.setNetwork(this.network);
        hotelsDAO.persist(hotelToCreate);
        return "hotels?faces-redirect=true&networkId=" + this.network.getId();
    }
}