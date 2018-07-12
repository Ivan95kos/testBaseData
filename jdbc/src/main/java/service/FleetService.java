package service;

import bl.Util;
import dao.FleetsDAO;
import entity.Fleets;
import entity.Ships;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FleetService extends Util implements FleetsDAO {

    Connection connection = getConnection();

    @Override
    public void add(Fleets fleets) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO fleets (idFleets, Fleet) VALUES (?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,fleets.getId());
            preparedStatement.setString(2, fleets.getFleet());

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
    public List<Fleets> getAll() throws SQLException {
        List<Fleets> fleetsList = new ArrayList<>();

        String sql = "SELECT idFleets, Fleet FROM fleets";

        Statement statement = null;

        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Fleets fleets = new Fleets();
                fleets.setId(resultSet.getLong("idFleets"));
                fleets.setFleet(resultSet.getString("Fleet"));

                fleetsList.add(fleets);
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
    public Fleets getById(Long id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT idFleets, Fleet FROM fleets WHERE id=?";

        Fleets fleets = new Fleets();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery(sql);

            fleets.setId(resultSet.getLong("idFleets"));
            fleets.setFleet(resultSet.getString("Fleet"));

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
        return fleets;
    }

    @Override
    public void update(Fleets fleets) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE fleets SET Fleet=? WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,fleets.getFleet());

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
    public void remove(Fleets fleets) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM fleets WHERE idFleets=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,fleets.getId());

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
