package ro.emanuel.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/songs/edit/{id}")
	public String editSong(Model model, @PathVariable int id) throws ClassNotFoundException, SQLException {
		Cantec c = CantecDAO.getById(id);
		
		model.addAttribute("cantec", c);
		
		return "/cantecEdit.jsp";
	}
	
	@PostMapping("/songs/edit")
	public String saveEditSong(@ModelAttribute("cantec") Cantec c,
			Model model, BindingResult result) throws ClassNotFoundException, SQLException {
		
		CantecDAO.update(c);
		
		return "redirect:/songs";
	}
	
	@GetMapping("/songs/createSong")
	public String createSong(Model model) {
		
		Cantec c = new Cantec();
		model.addAttribute("cantecNou", c);
		
		return "/createSong.jsp";
	}
	
	@PostMapping("/songs/saveNewSong")
	public String saveNewSong(@ModelAttribute("cantecNou") Cantec cantec) throws ClassNotFoundException, SQLException {
		
		CantecDAO.create(cantec);
		
		return "redirect:/songs";
	}
	
	@GetMapping("/songs/delete/{id}")
	public String deleteSong(@PathVariable int id) throws ClassNotFoundException, SQLException {
		
		CantecDAO.delete(id);
		
		return "redirect:/songs";
	}
	
}
