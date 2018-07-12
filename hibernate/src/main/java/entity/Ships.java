package entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table (name = "ships")
public class Ships {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Type_ship")
    private String typeShip;

    @Column(name = "Type_engine")
    private String typeEngine;

    @Column(name = "Type_hull")
    private String typeHull;

    @Column(name = "Passenger_capacity")
    private Long passengerCapacity;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "fleet_ships", joinColumns = @JoinColumn(name = "ID_SHIP"), inverseJoinColumns = @JoinColumn(name = "ID_FLEET"))
    private Set<Fleets> fleets;

    public Ships(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeShip() {
        return typeShip;
    }

    public void setTypeShip(String typeShip) {
        this.typeShip = typeShip;
    }

    public String getTypeEngine() {
        return typeEngine;
    }

    public void setTypeEngine(String typeEngine) {
        this.typeEngine = typeEngine;
    }

    public String getTypeHull() {
        return typeHull;
    }

    public void setTypeHull(String typeHull) {
        this.typeHull = typeHull;
    }

    public Long getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(Long passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public Set<Fleets> getFleets() {
        return fleets;
    }

    public void setFleets(Set<Fleets> fleets) {
        this.fleets = fleets;
    }

    @Override
    public String toString() {
        return "Ships{" +
                "id=" + id +
                ", typeShip='" + typeShip + '\'' +
                ", typeEngine='" + typeEngine + '\'' +
                ", typeHull='" + typeHull + '\'' +
                ", passengerCapacity=" + passengerCapacity +
                '}';
    }
}
