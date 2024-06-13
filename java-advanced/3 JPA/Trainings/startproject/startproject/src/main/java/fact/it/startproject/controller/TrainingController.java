package fact.it.startproject.controller;

import fact.it.startproject.model.Training;
import fact.it.startproject.repository.TrainingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TrainingController {
    private TrainingRepository trainingRepository;
    public TrainingController(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }
    @RequestMapping("/")
    public String index() {
        return "index";
    }
    @RequestMapping("/admin")
    public String admin(Model model, HttpServletRequest request) {
        List<Training> trainingList = trainingRepository.findAll();
        model.addAttribute("trainingList", trainingList);
        return "admin";
    }
    @RequestMapping("/add")
    public String add() {
        return "add";
    }
    @RequestMapping("/processadd")
    public String processadd(Model model, HttpServletRequest request) {
        String code = request.getParameter("code");
        String title = request.getParameter("title");
        String theme = request.getParameter("theme");
        Integer duration = Integer.parseInt(request.getParameter("duration"));
        Integer max = Integer.parseInt(request.getParameter("max"));
        Training training = new Training();
        training.setCode(code);
        training.setTitle(title);
        training.setTheme(theme);
        training.setDuration(duration);
        training.setMax(max);
        trainingRepository.save(training);
        List<Training> trainingList = trainingRepository.findAll();
        model.addAttribute("trainingList", trainingList);
        return "admin";
    }
    @RequestMapping("/edit")
    public String edit(Model model, HttpServletRequest request) {
        Long trainingId = Long.valueOf(request.getParameter("trainingId"));
        Training training =trainingRepository.getById(trainingId);
        model.addAttribute("training", training);
        return "edit";
    }
    @RequestMapping("/processedit")
    public String processedit(Model model, HttpServletRequest request) {
        Long trainingId = Long.valueOf(request.getParameter("trainingId"));
        String code = request.getParameter("code");
        String title = request.getParameter("title");
        String Theme = request.getParameter("Theme");
        Training training = new Training();
        training.setCode(code);
        training.setTitle(title);
        training.setTheme(Theme);
        trainingRepository.save(training);
        List<Training> trainingList = trainingRepository.findAll();
        model.addAttribute("trainingList", trainingList);
        return "admin";
    }
    @RequestMapping("/delete")
    public String delete(Model model, HttpServletRequest request) {
        Long trainingId = Long.valueOf(request.getParameter("trainingId"));
        trainingRepository.deleteById(trainingId);
        List<Training> trainingList = trainingRepository.findAll();
        model.addAttribute("trainingList", trainingList);
        return "admin";
    }
    @RequestMapping("/searchByTheme")
    public String searchByTheme(Model model, HttpServletRequest request) {
        String theme = request.getParameter("theme");
        List<Training> trainingList = trainingRepository.findAllOrderByThemesAsc();
        model.addAttribute("trainingList", trainingList);
        return "admin";
    }
    @RequestMapping("/singleTraining")
    public String singleTraining(Model model, HttpServletRequest request) {
        Long trainingId = Long.valueOf(request.getParameter("trainingId"));
        Training training = trainingRepository.getById(trainingId);
        model.addAttribute("training", training);
        return "singleTraining";
    }
    @RequestMapping("/advanceSearch")

    public String advanceSearch(Model model, HttpServletRequest request) {
        List<String> themeList = trainingRepository.findAllUniqueThemes();
        model.addAttribute("themeList", themeList);
        return "advanceSearch";
    }
    public String processAdvanceSearch(Model model, HttpServletRequest request) {
        String search = request.getParameter("search");
        List<Training> trainingList= trainingRepository.findByTitle(search);
        model.addAttribute("trainingList",trainingList);
//        String theme = request.getParameter("theme");
//        List<Training> trainingList = trainingRepository.findAllOrderByThemesAsc();
//        model.addAttribute("trainingList", trainingList);
        return "admin";
    }
}
