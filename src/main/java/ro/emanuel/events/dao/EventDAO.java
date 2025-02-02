package ro.emanuel.events.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import ro.emanuel.events.helpers.DBHelper;
import ro.emanuel.events.pojo.Event;
import ro.emanuel.events.pojo.Volunteer;
import ro.emanuel.events.pojo.Sponsor;

public class EventDAO {

    public static Event getById(int id) throws SQLException, ClassNotFoundException {
        Connection conn = DBHelper.getConnection();
        String query = "select * from events where id=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Event event = new Event(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("date"),
                rs.getString("location")
            );
            DBHelper.closeConnection();
            return event;
        }

        DBHelper.closeConnection();
        return null;
    }

    public static ArrayList<Event> getAll() throws ClassNotFoundException, SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "select * from events";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        ArrayList<Event> events = new ArrayList<>();

        while (rs.next()) {
            Event event = new Event(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("date"),
                rs.getString("location")
            );
            events.add(event);
        }
        DBHelper.closeConnection();
        return events;
    }

    public static void update(Event e) throws ClassNotFoundException, SQLException {
        String update = "update events set name=?, date=?, location=? where id=?";

        Connection conn = DBHelper.getConnection();

        PreparedStatement stmt = conn.prepareStatement(update);
        stmt.setString(1, e.getName());
        stmt.setString(2, e.getDate());
        stmt.setString(3, e.getLocation());
        stmt.setInt(4, e.getId());
      
        stmt.executeUpdate();
       
        DBHelper.closeConnection();
        
    }

    public static void create(Event e) throws ClassNotFoundException, SQLException {
        String createQuery = "insert into events (name, date, location) values(?, ?, ?)";
        Connection conn = DBHelper.getConnection();

        PreparedStatement stmt = conn.prepareStatement(createQuery);
        stmt.setString(1, e.getName());
        stmt.setString(2, e.getDate());
        stmt.setString(3, e.getLocation());

        stmt.executeUpdate();

        DBHelper.closeConnection();
    }

    public static void delete(int id) throws ClassNotFoundException, SQLException {
        String deleteQuery = "delete from events where id=" + id;
        Connection conn = DBHelper.getConnection();


        Statement stmt = conn.createStatement();
        stmt.executeUpdate(deleteQuery);

        DBHelper.closeConnection();
    }
}
