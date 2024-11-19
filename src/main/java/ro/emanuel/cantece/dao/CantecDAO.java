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

}
