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
import persistence.HotelsDAO;
import entities.Client;
import persistence.ClientsDAO;
import javax.transaction.Transactional;

@Model
public class ClientsForHotel implements Serializable {

    @Inject
    private HotelsDAO hotelsDAO;

    @Inject
    private ClientsDAO clientsDAO;

    @Getter @Setter
    private Integer hotelId;
    @Getter @Setter
    private Integer clientId;

    @Getter @Setter
    private Hotel hotel;


    @Transactional
    public String createClient() {
        Client client = clientsDAO.findOne(clientId);
        Hotel hotel = hotelsDAO.findOne(hotelId);
        hotel.AddClient(client, hotel);

        return "index?faces-redirect=true";
    }
}