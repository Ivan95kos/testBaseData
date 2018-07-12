package dao;

import entity.FleetShips;
import entity.Ships;

import java.sql.SQLException;
import java.util.List;

public interface FleetShipsDAO {

    //create
    void add(FleetShips fleetShips) throws SQLException;

    //read
    List<FleetShips> getAll() throws SQLException;

    FleetShips getByFleetIdAndShipId(Long idFleet, Long idShip) throws SQLException;

    //update
    void update(FleetShips fleetShips) throws SQLException;

    //delete
    void remove(FleetShips fleetShips) throws SQLException;
}
