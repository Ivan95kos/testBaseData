package dao;

import entity.Ships;

import java.sql.SQLException;
import java.util.List;

public interface ShipsDAO {

    //create
    void add(Ships ships) throws SQLException;

    //read
    List<Ships> getAll() throws SQLException;

    Ships getById(Long id) throws SQLException;

    //update
    void update(Ships ships) throws SQLException;

    //delete
    void remove(Ships ships) throws SQLException;
}
