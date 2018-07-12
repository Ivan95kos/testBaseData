package dao;

import entity.Fleets;

import java.sql.SQLException;
import java.util.List;

public interface FleetsDAO {

    //create
    void add(Fleets fleets) throws SQLException;

    //read
    List<Fleets> getAll() throws SQLException;

    Fleets getById(Long id) throws SQLException;

    //update
    void update(Fleets fleets) throws SQLException;

    //delete
    void remove(Fleets fleets) throws SQLException;
}
