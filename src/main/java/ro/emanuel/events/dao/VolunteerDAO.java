package ro.emanuel.events.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ro.emanuel.events.helpers.DBHelper;
import ro.emanuel.events.pojo.Volunteer;

public class VolunteerDAO {

	public static void create(Volunteer s) throws ClassNotFoundException, SQLException {
        String createQuery = "insert into volunteers (name, contactInfo, eventId) values(?, ?, ?)";
        Connection conn = DBHelper.getConnection();

        PreparedStatement stmt = conn.prepareStatement(createQuery);
        stmt.setString(1, s.getName());
        stmt.setString(2, s.getContactInfo());
        stmt.setInt(3, s.getEventId());

        stmt.executeUpdate();

        DBHelper.closeConnection();
    }
	
    public static ArrayList<Volunteer> getAllByEventId(int eventId) throws SQLException, ClassNotFoundException {
        Connection conn = DBHelper.getConnection();
        String query = "SELECT * FROM volunteers WHERE eventId=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, eventId);

        ResultSet rs = ps.executeQuery();
        ArrayList<Volunteer> volunteers = new ArrayList<>();

        while (rs.next()) {
            Volunteer volunteer = new Volunteer(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("contactInfo"),
                rs.getInt("eventId")
            );
            volunteers.add(volunteer);
        }

        DBHelper.closeConnection();
        return volunteers;
    }

    public static void deleteById(int id) throws SQLException, ClassNotFoundException {
        Connection conn = DBHelper.getConnection();
        String query = "DELETE FROM volunteers WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
        DBHelper.closeConnection();
    }

    public static void deleteAllByEventId(int eventId) throws SQLException, ClassNotFoundException {
        Connection conn = DBHelper.getConnection();
        String query = "DELETE FROM volunteers WHERE eventId=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, eventId);
        ps.executeUpdate();
        DBHelper.closeConnection();
    }
}
