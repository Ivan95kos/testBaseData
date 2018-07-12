package entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "fleets")
public class Fleets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Fleet")
    private String fleet;

    @ManyToMany(mappedBy = "fleets")
    private Set<Ships> ships;

    public Fleets(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFleet() {
        return fleet;
    }

    public void setFleet(String fleet) {
        this.fleet = fleet;
    }

    public Set<Ships> getShips() {
        return ships;
    }

    public void setShips(Set<Ships> ships) {
        this.ships = ships;
    }

    @Override
    public String toString() {
        return "Fleets{" +
                "id=" + id +
                ", fleet='" + fleet + '\'' +
                '}';
    }
}
