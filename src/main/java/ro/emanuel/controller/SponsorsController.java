package ro.emanuel.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ro.emanuel.events.dao.SponsorDAO;
import ro.emanuel.events.pojo.Sponsor;

@Controller
public class SponsorsController {
    
    
    @GetMapping("/event/{eventId}/sponsor-form")
    public String createSponsorForm(@PathVariable int eventId, Model model) {
        // Create an empty Sponsor object
        Sponsor sponsor = new Sponsor();
        model.addAttribute("sponsor", sponsor);
        model.addAttribute("eventId", eventId);
        
        return "/sponsor-form.jsp";
    }
    
    @PostMapping("/event/{eventId}/sponsor/save")
    public String saveSponsor(@PathVariable int eventId, Sponsor sponsor) throws ClassNotFoundException, SQLException {
        // Associate sponsor with the sponsor and save to the database
        sponsor.setEventId(eventId);
        SponsorDAO.create(sponsor);
        return "redirect:/event?id=" + eventId;

    }
    
    @GetMapping("/event/{eventId}/sponsor/delete")
    public String deleteSponsor(@RequestParam int id,@PathVariable int eventId) throws ClassNotFoundException, SQLException {
        // Delete sponsor from the database
        SponsorDAO.deleteById(id);
        return "redirect:/event?id="+eventId;
    }
    
}
