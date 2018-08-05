package com.example.resumebuilder;

import com.example.resumebuilder.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    PersonRepository personRepo;

    @Autowired
    ResumeRepository resumeRepo;

    @Autowired
    EducationRepository educationRepo;

    @Autowired
    ExperienceRepository experienceRepo;

    @Autowired
    ReferenceRepository referenceRepo;

    @Autowired
    SkillRepository skillRepo;

    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }

    //Create, list, and save person
    @RequestMapping("/addperson")
    public String addPerson(Model model){
        model.addAttribute("thePerson", new Person());
        return "addpersonform";
    }

    @RequestMapping("/listpeople")
    public String listPeople(Model model){
        model.addAttribute("allpeople", personRepo.findAll());
        model.addAttribute("allresumes", resumeRepo.findAll()); //added at 4:08pm
        return "listpeople";
    }

    @PostMapping("/saveperson")
    public String savePerson(@Valid @ModelAttribute("thePerson") Person person, BindingResult result){
        personRepo.save(person);
        return "redirect:listpeople";
    }

    //Don't need yet!!! This is fluff.
    @RequestMapping("/editPerson")
    public String editPerson(HttpServletRequest request, Model model) {
        long id = new Long(request.getParameter("id"));
        model.addAttribute("thePerson", personRepo.findById(id).get());
        return "addpersonform";
    }

    //More fluff that shows and individual person's info.
    @RequestMapping("/personinfo/{id}")
    public String personInformation(@PathVariable("id") long id, Model model){
        model.addAttribute("thePerson", personRepo.findById(id).get());
        return "personinfo";
    }

    //Create, associate with person, and save resume
/*    @RequestMapping("/createresume")
    public String createResume(Model model, HttpServletRequest request){    //Added HttpServletRequest request

        String personID = request.getParameter("personid");

        Resume aResume = new Resume();

        if(personID!=null){
            aResume.setPersonResume(personRepo.findById(new Long(personID)).get());
        }

//        model.addAttribute("theResume", new Resume());
        model.addAttribute("theResume", aResume);
        return "createresumeform";
    }*/

    @RequestMapping("/createresumeform")
    public String  createResume(Model model){
        AddExperience experienceForm = new AddExperience();

        for(int i = 1; i <- 3; i++){
            experienceForm.addExperience(new Experience());
        }

        model.addAttribute("resume", experienceForm); //set the object the same for each new instance
        model.addAttribute("resume", new Resume());
        model.addAttribute("experience", new Experience());
        model.addAttribute("education", new Education());
        model.addAttribute("reference", new Reference());
        model.addAttribute("skill", new Skill());
        model.addAttribute("allpeople", personRepo.findAll()); //added since you are adding/syncing to person. Possibly include a dropdown menu for all of the persons
        return "createresumeform";
    }

    @RequestMapping("/addresumeform")
    public String  addResumeForm(Model model){
        model.addAttribute("resume", new Resume());//don't know the purpose of
        return "addresume";
    }

    //Maybe insert a list of resume for the person and give them the option to choose a resume
    @RequestMapping("/listresume")
    public String listResumes(Model model){
        model.addAttribute("allresumes", resumeRepo.findAll());
        return "listresume";
    }

    //Show Resume
    @RequestMapping("/resume/{id}")
    public String individualResume(@PathVariable("id") long id, Model model){
        model.addAttribute("resume", resumeRepo.findById(id).get());
        return "resume";
    }
//    Added in hopes of displaying experience: http://www.baeldung.com/thymeleaf-list
    @GetMapping("/resume/{id}")
    public String showAll(Model model){
        model.addAttribute("experiences", experienceRepo.findAll());
        return "resume";
    }

    @RequestMapping("/resume")
    public String thisResume(Model model){
//        model.addAttribute("allresumes", resumeRepo.findAll()); //removed to test if I should use findAll for Person(s) instead
        model.addAttribute("allpeople", personRepo.findAll());
        model.addAttribute("experiences", experienceRepo.findAll());
        return "resume";
    }

    @PostMapping("/saveresume")
    public String saveResume(@ModelAttribute("resume") Resume resume, BindingResult result){
        resumeRepo.save(resume);
        return "redirect:listpeople";
    }

    //Remove and show resumes under personInfo() instead
    @RequestMapping("/resumes")
    public String showResumes(Model model){
        model.addAttribute("allresumes", resumeRepo.findAll());//removed resumelist because I don't know why it's there
        //This should direct to personinfo.
        return "showresumeinfo";
    }
}
