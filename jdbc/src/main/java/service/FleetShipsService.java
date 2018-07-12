package service;

import bl.Util;
import dao.FleetShipsDAO;
import entity.FleetShips;
import entity.Fleets;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FleetShipsService extends Util implements FleetShipsDAO {

    Connection connection = getConnection();

    @Override
    public void add(FleetShips fleetShips) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO fleet_ships (id_fleets, id_ships) VALUES (?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, fleetShips.getIdFleet());
            preparedStatement.setLong(2, fleetShips.getIdShip());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public List<FleetShips> getAll() throws SQLException {
        List<FleetShips> fleetsList = new ArrayList<>();

        String sql = "SELECT id_fleets, id_ships FROM fleet_ships";

        Statement statement = null;

        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                FleetShips fleetShips = new FleetShips();
                fleetShips.setIdFleet(resultSet.getLong("id_fleets"));
                fleetShips.setIdShip(resultSet.getLong("id_ships"));

                fleetsList.add(fleetShips);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return fleetsList;
    }

    @Override
    public FleetShips getByFleetIdAndShipId(Long idFleet, Long idShip) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT id_fleets, id_ships FROM fleet_ships WHERE id_fleets=? AND id_ships=?";

        FleetShips fleetShips = new FleetShips();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, idFleet);
            preparedStatement.setLong(2, idShip);

            ResultSet resultSet = preparedStatement.executeQuery(sql);

            fleetShips.setIdFleet(resultSet.getLong("id_fleets"));
            fleetShips.setIdShip(resultSet.getLong("id_ships"));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return fleetShips;
    }

    @Override
    public void update(FleetShips fleetShips) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE fleet_ships SET id_fleets=?, id_ships=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,fleetShips.getIdFleet());
            preparedStatement.setLong(2,fleetShips.getIdShip());

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        }

    }

    @Override
    public void remove(FleetShips fleetShips) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM fleet_ships WHERE id_fleets=? AND id_ships";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,fleetShips.getIdFleet());
            preparedStatement.setLong(1,fleetShips.getIdShip());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }

            if (connection != null){
                connection.close();
            }
        }
    }
}
