package domain;

import bl.HibernateUtil;
import entity.Fleets;
import entity.Ships;
import org.hibernate.Session;
import service.FleetsService;
import service.ShipsService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Domain {
    public static void main(String[] args) throws SQLException {

        FleetsService fleetsService = new FleetsService();
        ShipsService shipsService = new ShipsService();

        Fleets fleets = new Fleets();
        fleets.setFleet("Federation2");

        Ships ships = new Ships();
        ships.setTypeShip("Passenger's2");
        ships.setTypeEngine("Electro2");
        ships.setTypeHull("Metal2");
        ships.setPassengerCapacity(100L);


        Set<Fleets> fleetsSet = new HashSet<Fleets>();
        fleetsSet.add(fleets);
        ships.setFleets(fleetsSet);

        Set<Ships> shipsSet = new HashSet<Ships>();
        shipsSet.add(ships);
        fleets.setShips(shipsSet);


//        List<Ships> shipsList = shipsService.getAll();
//        for (Ships s: shipsList){
//            System.out.println(s);
//        }

        fleetsService.add(fleets);
        shipsService.add(ships);

//        fleetsService.remove(fleets);
//        shipsService.remove(ships);

        HibernateUtil.shutdown();

    }
}
