package service;

import bl.Util;
import dao.ShipsDAO;
import entity.Ships;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShipService extends Util implements ShipsDAO {

    Connection connection = getConnection();

    @Override
    public void add(Ships ships) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO ships (id, Type_ship, Type_engine, Type_hull, Passenger_capacity) VALUES (?, ?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, ships.getId());
            preparedStatement.setString(2, ships.getTypeShip());
            preparedStatement.setString(3, ships.getTypeEngine());
            preparedStatement.setString(4, ships.getTypeHull());
            preparedStatement.setLong(5, ships.getPassengerCapacity());

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
    public List<Ships> getAll() throws SQLException {
        List<Ships> shipsList = new ArrayList<>();

        String sql = "SELECT id, Type_ship, Type_engine, Type_hull, Passenger_capacity FROM ships";

        Statement statement = null;

        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Ships ships = new Ships();
                ships.setId(resultSet.getLong("id"));
                ships.setTypeShip(resultSet.getString("Type_ship"));
                ships.setTypeEngine(resultSet.getString("Type_engine"));
                ships.setTypeHull(resultSet.getString("Type_hull"));
                ships.setPassengerCapacity(resultSet.getLong("Passenger_capacity"));

                shipsList.add(ships);
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
        return shipsList;
    }

    @Override
    public Ships getById(Long id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT id, Type_ship, Type_engine, Type_hull, Passenger_capacity FROM ships WHERE id=?";

        Ships ships = new Ships();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery(sql);

            ships.setId(resultSet.getLong("id"));
            ships.setTypeShip(resultSet.getString("Type_ship"));
            ships.setTypeEngine(resultSet.getString("Type_engine"));
            ships.setTypeHull(resultSet.getString("Type_hull"));
            ships.setId(resultSet.getLong("Passenger_capacity"));

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
        return ships;
    }

    @Override
    public void update(Ships ships) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE ships SET Type_ship=?, Type_engine=?, Type_hull=?, Passenger_capacity=? WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,ships.getTypeShip());
            preparedStatement.setString(2,ships.getTypeEngine());
            preparedStatement.setString(3,ships.getTypeHull());
            preparedStatement.setLong(4,ships.getPassengerCapacity());

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
    public void remove(Ships ships) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM ships WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,ships.getId());

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
