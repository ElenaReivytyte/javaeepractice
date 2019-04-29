package entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

@Entity
@NamedQueries({
        @NamedQuery(name = "Network.findAll", query = "select n from Network as n")
})
@Table(name = "NETWORK")
@Getter @Setter
public class Network {
    public Network(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String networkName;

    @OneToMany(mappedBy = "network")
    private List<Hotel> hotels = new ArrayList<>();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Network network = (Network) obj;
        return Objects.equals(networkName, network.networkName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(networkName);
    }
}

