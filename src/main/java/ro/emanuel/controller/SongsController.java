package ro.emanuel.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ro.emanuel.cantece.dao.CantecDAO;
import ro.emanuel.cantece.pojo.Cantec;

@Controller
public class SongsController {
	
	@GetMapping("/song")
	public String singleSong(@RequestParam int id, Model model) throws SQLException, ClassNotFoundException {
		//iau cantecul cu id-ul x(param) din baza de date/ obiectul din db
		Cantec c = CantecDAO.getById(id);
		
		//adaug cantecul in pagina jsp
		model.addAttribute("s", c);
		
		return "song.jsp";
		
	}
	
	@GetMapping("/songs")
	public String allSongs(Model model) throws ClassNotFoundException, SQLException {
		//aduc toate cantecele din db
		ArrayList<Cantec> allSongs = CantecDAO.getAll();
		
		//adaug cantecele in pagina
		model.addAttribute("all", allSongs);
		
		return "songs.jsp";
	}

}
