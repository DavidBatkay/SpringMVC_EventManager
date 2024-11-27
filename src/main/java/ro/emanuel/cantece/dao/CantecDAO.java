package ro.emanuel.cantece.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.cantece.helpers.DBHelper;
import ro.emanuel.cantece.pojo.Cantec;

public class CantecDAO {

	public static Cantec getById(int id) throws SQLException, ClassNotFoundException {
		 Connection conn = DBHelper.getConnection();
	     String query = "select * from cantec where id=?";
	     PreparedStatement ps = conn.prepareStatement(query);
	     ps.setInt(1, id);
	         
	        ResultSet rs = ps.executeQuery();
	        
	        if(rs.next()) {
	        	Cantec cantec = new Cantec (rs.getInt("id"),
	        			rs.getString("titlu"),
	        			rs.getString("autor"),
	        			rs.getString("linkPartitura"),
	        			rs.getString("versuri"),
	        			rs.getInt("nrVoturi"));
	        	DBHelper.closeConnection();
	        	return cantec;
	        }
	        
	        DBHelper.closeConnection();
	        return null;
	}
	
	public static ArrayList<Cantec> getAll() throws ClassNotFoundException, SQLException{
        Connection conn=DBHelper.getConnection();
        String query="select * from cantec";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        ArrayList<Cantec> songs = new ArrayList<>();
        
        
        while(rs.next()) {
            Cantec cantec=new Cantec(rs.getInt("id"),
                    rs.getString("titlu"),
                    rs.getString("autor"),
                    rs.getString("linkPartitura"),
                    rs.getString("versuri"),
                    rs.getInt("nrVoturi"));
            songs.add(cantec);
        }
        DBHelper.closeConnection();
        return songs;
    }
	
	public static void update(Cantec c) throws ClassNotFoundException, SQLException {
		String update = "update cantec set titlu=?, autor=?, "
				+"linkPartitura=?, versuri=?, nrVoturi=? where id=?";
		
		//conexiune
		Connection conn = DBHelper.getConnection();
		
		//prepared stmt
		PreparedStatement stmt = conn.prepareStatement(update);
		stmt.setString(1, c.getTitlu());
		stmt.setString(2, c.getAutor());
		stmt.setString(3, c.getLinkPartitura());
		stmt.setString(4, c.getVersuri());
		stmt.setInt(5, c.getNrVoturi());
		stmt.setInt(6, c.getId());
		
		//execute stmt
		stmt.executeUpdate();
		
		DBHelper.closeConnection();

	}	
	
	public static void create(Cantec c) throws ClassNotFoundException, SQLException {
		String createQuery = "insert into cantec (titlu, autor, linkPartitura, versuri, nrVoturi) values(?, ?, ?, ?, ?)";
		Connection conn = DBHelper.getConnection();
		
		//prepared stmt
		PreparedStatement stmt = conn.prepareStatement(createQuery);
		stmt.setString(1, c.getTitlu());
		stmt.setString(2, c.getAutor());
		stmt.setString(3, c.getLinkPartitura());
		stmt.setString(4, c.getVersuri());
		stmt.setInt(5, c.getNrVoturi());
		
		//execute stmt
		stmt.executeUpdate();
		
		DBHelper.closeConnection();

	}
	
	public static void delete(int id) throws ClassNotFoundException, SQLException {
		String deleteQuery = "delete from cantec where id=" + id;
		Connection conn = DBHelper.getConnection();
	
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(deleteQuery);

		
		DBHelper.closeConnection();

	}
}
