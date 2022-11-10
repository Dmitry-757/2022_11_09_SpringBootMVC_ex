package org.dng.springbootmvc_2022_11_09.Controllers;

import org.dng.springbootmvc_2022_11_09.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/start")
//    public String getHelloPage(Model model, @RequestParam(value = "name") String name){
//            model.addAttribute("name", name);
    public String getHelloPage(){
        return "start";
    }
    @GetMapping("/students")
    public String showStudentsList(Model model){
        model.addAttribute("listOfStudents", studentService.getAll());
        return "students";
    }
}
