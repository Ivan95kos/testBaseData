package entity;

public class FleetShips {

    private Long idFleet;

    private Long idShip;

    public FleetShips(){

    }

    public Long getIdFleet() {
        return idFleet;
    }

    public void setIdFleet(Long idFleet) {
        this.idFleet = idFleet;
    }

    public Long getIdShip() {
        return idShip;
    }

    public void setIdShip(Long idShip) {
        this.idShip = idShip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FleetShips that = (FleetShips) o;

        if (idFleet != null ? !idFleet.equals(that.idFleet) : that.idFleet != null) return false;
        return idShip != null ? idShip.equals(that.idShip) : that.idShip == null;
    }

    @Override
    public int hashCode() {
        int result = idFleet != null ? idFleet.hashCode() : 0;
        result = 31 * result + (idShip != null ? idShip.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FleetShips{" +
                "idFleet=" + idFleet +
                ", idShip=" + idShip +
                '}';
    }
}
