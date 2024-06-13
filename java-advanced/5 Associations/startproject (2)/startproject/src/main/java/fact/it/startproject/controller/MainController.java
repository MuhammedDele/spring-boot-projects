package fact.it.startproject.controller;

import fact.it.startproject.model.Club;
import fact.it.startproject.model.Event;
import fact.it.startproject.model.Jogger;
import fact.it.startproject.repository.ClubRepository;
import fact.it.startproject.repository.EventRepository;
import fact.it.startproject.repository.JoggerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MainController {
    private final ClubRepository clubRepository;
    private JoggerRepository joggerRepository;
    private EventRepository eventRepository;
    private ClubRepository ClubRepository;
    public MainController(JoggerRepository joggerRepository, EventRepository eventRepository, ClubRepository clubRepository) {
        this.joggerRepository = joggerRepository;
        this.eventRepository = eventRepository;
        this.clubRepository = clubRepository;
    }
    @RequestMapping("/")
    public String index() {

        return "index";
    }
    @RequestMapping("/overview")
    public String overview(Model model) {
        List<Club> clubs = clubRepository.findAll();
        model.addAttribute("clubs", clubs);
        return "overview";
    }
    @RequestMapping("/joggers")
    public String joggers(Model model) {
        List<Jogger> joggerList = joggerRepository.findAll();
        model.addAttribute("joggerList", joggerList);
        return "joggers";
    }
    @RequestMapping("/deleteJogger")
    public String deleteJogger(Model model, HttpServletRequest request) {
        Long joggerId = Long.valueOf(request.getParameter("joggerId"));
        joggerRepository.deleteById(joggerId);
        List<Jogger> joggerList = joggerRepository.findAll();
        model.addAttribute("joggerList", joggerList);
        return "joggers";
    }
    @RequestMapping("/events")
    public String events(Model model, HttpServletRequest request) {
        List<Event> eventList = eventRepository.findAll();
        model.addAttribute("eventList", eventList);
        return "events";
    }
    @RequestMapping("/editEvent")
    public String editEvent(Model model, HttpServletRequest request) {
        Long eventId = Long.valueOf(request.getParameter("eventId"));
        Event event=eventRepository.getById(eventId);
        model.addAttribute("event", event);
        List<Club> clubList = clubRepository.findAll();
        model.addAttribute("clubList", clubList);
        return "editEvent";
    }
    @RequestMapping("/processEditEvent")
    public String processEditEvent(Model model, HttpServletRequest request) {
        Long eventId = Long.valueOf(request.getParameter("eventId"));
        String name = request.getParameter("name");
        Integer year = Integer.parseInt(request.getParameter("year"));
        String location = request.getParameter("location");
        Long clubId =  Long.valueOf(request.getParameter("club"));
        Event event = eventRepository.getById(eventId);
        event.setName(name);
        event.setYear(year);
        event.setLocation(location);
        Club club=clubRepository.getById(clubId);
        event.setClub(club);
        eventRepository.save(event);
        List<Event> eventList = eventRepository.findAll();
        model.addAttribute("eventList",eventList);
        return "events";
    }
}
