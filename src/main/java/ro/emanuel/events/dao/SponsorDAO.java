package ro.emanuel.events.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ro.emanuel.events.helpers.DBHelper;
import ro.emanuel.events.pojo.Event;
import ro.emanuel.events.pojo.Sponsor;

public class SponsorDAO {

	public static void create(Sponsor s) throws ClassNotFoundException, SQLException {
        String createQuery = "insert into sponsors (name, amount, eventId) values(?, ?, ?)";
        Connection conn = DBHelper.getConnection();

        PreparedStatement stmt = conn.prepareStatement(createQuery);
        stmt.setString(1, s.getName());
        stmt.setString(2, s.getAmount());
        stmt.setInt(3, s.getEventId());

        stmt.executeUpdate();

        DBHelper.closeConnection();
    }
	
    public static ArrayList<Sponsor> getAllByEventId(int eventId) throws SQLException, ClassNotFoundException {
        Connection conn = DBHelper.getConnection();
        String query = "SELECT * FROM sponsors WHERE eventId=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, eventId);

        ResultSet rs = ps.executeQuery();
        ArrayList<Sponsor> sponsors = new ArrayList<>();

        while (rs.next()) {
            Sponsor sponsor = new Sponsor(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("amount"),
                rs.getInt("eventId")
            );
            sponsors.add(sponsor);
        }

        DBHelper.closeConnection();
        return sponsors;
    }

    public static void deleteById(int id) throws SQLException, ClassNotFoundException {
        Connection conn = DBHelper.getConnection();
        String query = "DELETE FROM sponsors WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
        DBHelper.closeConnection();
    }

    public static void deleteAllByEventId(int eventId) throws SQLException, ClassNotFoundException {
        Connection conn = DBHelper.getConnection();
        String query = "DELETE FROM sponsors WHERE eventId=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, eventId);
        ps.executeUpdate();
        DBHelper.closeConnection();
    }

}
