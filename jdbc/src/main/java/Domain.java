import bl.Util;
import entity.FleetShips;
import entity.Fleets;
import entity.Ships;
import service.FleetService;
import service.FleetShipsService;
import service.ShipService;

import java.sql.SQLException;
import java.util.List;

public class Domain {
    public static void main(String[] args) {

        FleetService fleetService = new FleetService();
        ShipService shipService = new ShipService();
        FleetShipsService fleetShipsService = new FleetShipsService();

        Fleets fleets = new Fleets();
        fleets.setId(5L);
        fleets.setFleet("moto");

        Ships ships = new Ships();
        ships.setId(6L);
        ships.setTypeShip("moto1");
        ships.setTypeEngine("moto2");
        ships.setTypeHull("moto3");
        ships.setPassengerCapacity(2L);

        FleetShips fleetShips = new FleetShips();
        fleetShips.setIdFleet(fleets.getId());
        fleetShips.setIdShip(ships.getId());

        try {
//            fleetService.add(fleets);
//            shipService.add(ships);
//            fleetShipsService.add(fleetShips);

//            fleetService.remove(fleets);
//            shipService.remove(ships);
//            fleetShipsService.remove(fleetShips);

            List<Ships> shipsList = shipService.getAll();

            for (Ships ships1: shipsList) {
                System.out.println(ships1);

            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
