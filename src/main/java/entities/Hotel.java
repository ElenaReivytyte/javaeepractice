package entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Hotel.findAll", query = "select a from Hotel as a")
})

@Table(name = "HOTEL")
@Getter @Setter
public class Hotel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "HOTELNAME")
    private String hotelName;
    @ManyToOne
    @JoinColumn(name="NETWORK_ID")
    private Network network;
    @JoinTable(name = "CLIENT_HOTEL", joinColumns = {
            @JoinColumn(name = "HOTEL_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
            @JoinColumn(name = "CLIENT_ID", referencedColumnName = "ID")
    })
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Client> clientList = new ArrayList<>();
    public Hotel(){
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Hotel hotel = (Hotel) obj;
        return Objects.equals(id, hotel.id) &&
                Objects.equals(hotelName, hotel.hotelName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hotelName);
    }

    public void AddClient(Client client, Hotel hotel){
        this.clientList.add(client);
    }
}
