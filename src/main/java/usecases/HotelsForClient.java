package usecases;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

import entities.Hotel;
import entities.Client;
import persistence.ClientsDAO;
import persistence.HotelsDAO;

import javax.transaction.Transactional;

@Model
public class HotelsForClient implements Serializable {

    @Inject
    private HotelsDAO hotelsDAO;

    @Getter @Setter
    private Hotel hotel;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer hotelId = Integer.parseInt(requestParameters.get("hotelId"));
        this.hotel = hotelsDAO.findOne(hotelId);
    }
}