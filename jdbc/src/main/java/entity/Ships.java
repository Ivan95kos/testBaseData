package entity;

public class Ships {

    private Long id;

    private String typeShip;

    private String typeEngine;

    private String typeHull;

    private Long passengerCapacity;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ships ships = (Ships) o;

        if (id != null ? !id.equals(ships.id) : ships.id != null) return false;
        if (typeShip != null ? !typeShip.equals(ships.typeShip) : ships.typeShip != null) return false;
        if (typeEngine != null ? !typeEngine.equals(ships.typeEngine) : ships.typeEngine != null) return false;
        if (typeHull != null ? !typeHull.equals(ships.typeHull) : ships.typeHull != null) return false;
        return passengerCapacity != null ? passengerCapacity.equals(ships.passengerCapacity) : ships.passengerCapacity == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (typeShip != null ? typeShip.hashCode() : 0);
        result = 31 * result + (typeEngine != null ? typeEngine.hashCode() : 0);
        result = 31 * result + (typeHull != null ? typeHull.hashCode() : 0);
        result = 31 * result + (passengerCapacity != null ? passengerCapacity.hashCode() : 0);
        return result;
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
