package com.example.resumebuilder;

import com.example.resumebuilder.repository.PersonRepository;
import com.example.resumebuilder.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    PersonRepository personRepo;

    @Autowired
    ResumeRepository resumeRepo;

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

    @RequestMapping("/createresume")
    public String  createResume(Model model){
        model.addAttribute("theResume", new Resume());
        return "createresumeform";
    }

    //Maybe insert a list of resume for the person and give them the option to choose a resume
    @RequestMapping("/listresume")
    public String listResumes(Model model){
        model.addAttribute("allresumes", resumeRepo.findAll());
        return "listresume";
    }

    @RequestMapping("/resume/{id}")
    public String thisResume(@PathVariable("id") long id, Model model){
        model.addAttribute("thePerson", personRepo.findById(id).get());
        return "thisresume";
    }

    @PostMapping("/saveresume")
    public String saveResume(@ModelAttribute("theResume") Resume resume, BindingResult result){
        resumeRepo.save(resume);
        return "redirect:thisresume";
    }

    //Remove and show resumes under personInfo() instead
    @RequestMapping("/resumes")
    public String showResumes(Model model){
        model.addAttribute("resumelist", resumeRepo.findAll());
        //This should direct to personinfo.
        return "showresumeinfo";
    }
}
