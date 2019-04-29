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
        @NamedQuery(name = "Client.findAll", query = "select a from Client as a")
})

@Table(name = "CLIENT")
@Getter @Setter
public class Client implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(max = 50)
    @Column(name = "CLIENTNAME")
    private String clientName;

    @ManyToMany(mappedBy = "clientList", fetch = FetchType.EAGER)
    private List<Hotel> hotelList = new ArrayList<>();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Client client = (Client) obj;
        return Objects.equals(id, client.id) &&
                Objects.equals(clientName, client.clientName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientName);
    }
}
