package ro.emanuel.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ro.emanuel.events.dao.EventDAO;
import ro.emanuel.events.dao.VolunteerDAO;
import ro.emanuel.events.pojo.Volunteer;

@Controller
public class VolunteersController {
    
    
    @GetMapping("/event/{eventId}/volunteer-form")
    public String createVolunteerForm(@PathVariable int eventId, Model model) {
        // Create an empty Sponsor object
        Volunteer volunteer = new Volunteer();
        model.addAttribute("volunteer", volunteer);
        model.addAttribute("eventId", eventId);
        
        return "/volunteer-form.jsp";
    }
    
    @PostMapping("/event/{eventId}/volunteer/save")
    public String saveSponsor(@PathVariable int eventId, Volunteer volunteer) throws ClassNotFoundException, SQLException {
        // Associate sponsor with the event and save to the database
        volunteer.setEventId(eventId);
        VolunteerDAO.create(volunteer);
        return "redirect:/event?id=" + eventId;

    }
    
    @GetMapping("/event/{eventId}/volunteer/delete")
    public String deleteSponsor(@RequestParam int id,@PathVariable int eventId) throws ClassNotFoundException, SQLException {
        // Delete sponsor from the database
        VolunteerDAO.deleteById(id);
        return "redirect:/event?id="+eventId;
    }
    
}
