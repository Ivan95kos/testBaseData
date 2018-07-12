package entity;

public class Fleets {

    private Long id;

    private String fleet;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fleets fleets = (Fleets) o;

        if (id != null ? !id.equals(fleets.id) : fleets.id != null) return false;
        return fleet != null ? fleet.equals(fleets.fleet) : fleets.fleet == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fleet != null ? fleet.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Fleets{" +
                "id=" + id +
                ", fleet='" + fleet + '\'' +
                '}';
    }
}
