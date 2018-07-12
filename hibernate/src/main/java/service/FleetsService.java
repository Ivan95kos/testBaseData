package service;

import bl.SessionUtil;
import dao.FleetsDAO;
import entity.Fleets;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class FleetsService extends SessionUtil implements FleetsDAO {

    public void add(Fleets fleets) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(fleets);

        //close session with a transaction
        closeTransactoinSession();
    }

    public List<Fleets> getAll() throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM fleets";

        Session session = getSession();
        Query queue = session.createNativeQuery(sql).addEntity(Fleets.class);
        List<Fleets> fleetsList = queue.list();

        //close session with a transaction
        closeTransactoinSession();

        return fleetsList;
    }

    public Fleets getById(Long id) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM fleets WHERE id = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Fleets.class);
        query.setParameter("id", id);

        Fleets fleets = (Fleets) query.getSingleResult();

        //close session with a transaction
        closeTransactoinSession();


        return fleets;
    }

    public void update(Fleets fleets) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.update(fleets);

        //close session with a transaction
        closeTransactoinSession();
    }

    public void remove(Fleets fleets) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(fleets);

        //close session with a transaction
        closeTransactoinSession();
    }
}
