package service;

import bl.SessionUtil;
import dao.ShipsDAO;
import entity.Ships;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class ShipsService extends SessionUtil implements ShipsDAO {
    public void add(Ships ships) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(ships);

        //close session with a transaction
        closeTransactoinSession();
    }

    public List<Ships> getAll() throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM ships";

        Session session = getSession();
        Query queue = session.createNativeQuery(sql).addEntity(Ships.class);
        List<Ships> shipsList = queue.list();

        //close session with a transaction
        closeTransactoinSession();

        return shipsList;
    }

    public Ships getById(Long id) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM ships WHERE id = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Ships.class);
        query.setParameter("id", id);

        Ships ships = (Ships) query.getSingleResult();

        //close session with a transaction
        closeTransactoinSession();


        return ships;
    }

    public void update(Ships ships) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.update(ships);

        //close session with a transaction
        closeTransactoinSession();


    }

    public void remove(Ships ships) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(ships);

        //close session with a transaction
        closeTransactoinSession();

    }
}
