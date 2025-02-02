package ro.emanuel.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ro.emanuel.events.dao.EventDAO;
import ro.emanuel.events.dao.SponsorDAO;
import ro.emanuel.events.dao.VolunteerDAO;
import ro.emanuel.events.pojo.Event;
import ro.emanuel.events.pojo.Sponsor;
import ro.emanuel.events.pojo.Volunteer;

@Controller
public class EventsController {
	
	@GetMapping("/events")
	public String allEvents(Model model) throws ClassNotFoundException, SQLException {
		//aduc toate eventurile din db
		ArrayList<Event> allEvents = EventDAO.getAll();
		
		//adaug eventurile in pagina
		model.addAttribute("all", allEvents);
		
		return "/events.jsp";
	}
	
	@GetMapping("/event")
	public String event(Model model, @RequestParam int id) throws ClassNotFoundException, SQLException {
		Event event = EventDAO.getById(id);
		ArrayList<Sponsor> allSponsors = SponsorDAO.getAllByEventId(id);
		ArrayList<Volunteer> allVolunteers = VolunteerDAO.getAllByEventId(id);
		model.addAttribute("volunteers",allVolunteers);
		model.addAttribute("sponsors",allSponsors);
		model.addAttribute("event",event);
		return "/event.jsp";
	}
	
	
	@GetMapping("/createEvent")
	public String createEvent(Model model) {
	    model.addAttribute("event", new Event());
	    return "/createEvent.jsp";
	}

	
	@GetMapping("/event/update")
	public String updateEvent(Model model, @RequestParam int id) throws ClassNotFoundException, SQLException {
		Event event = EventDAO.getById(id);
		
		model.addAttribute("event",event);
		
		return "/eventEdit.jsp";
	}
	
	@PostMapping("/event/update")
	public String saveEvent(Model model, Event event) throws ClassNotFoundException, SQLException {
		EventDAO.update(event);
		System.out.println(event.getId());
		return "redirect:/events";
	}
	
	@GetMapping("/event/delete")
	public String delete(@RequestParam int id) throws ClassNotFoundException, SQLException {
		SponsorDAO.deleteAllByEventId(id);
		VolunteerDAO.deleteAllByEventId(id);
		EventDAO.delete(id);
		
		return "redirect:/events";
	}
	
	@PostMapping("/event/save")
	public String saveEvent(Event event) throws ClassNotFoundException, SQLException {
		EventDAO.create(event);
		return "redirect:/events";
	}
	
}
