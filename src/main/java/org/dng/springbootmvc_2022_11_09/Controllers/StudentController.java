package org.dng.springbootmvc_2022_11_09.Controllers;

import org.dng.springbootmvc_2022_11_09.Service.GroupService;
import org.dng.springbootmvc_2022_11_09.model.Group;
import org.dng.springbootmvc_2022_11_09.model.Student;
import org.dng.springbootmvc_2022_11_09.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private GroupService groupService;

    @GetMapping("/start")
//    public String getHelloPage(Model model, @RequestParam(value = "name") String name){
//            model.addAttribute("name", name);
    public String getHelloPage() {
        return "start";
    }

    @GetMapping("/students")
    public String showStudentsList(Model model) {
        model.addAttribute("listOfStudents", studentService.getAll());
        return "students";
    }

    @GetMapping("students/delete")
    public String removeStudent(Model model, @RequestParam(name = "id") long id) {
        if (id > 0) {
            studentService.delete(id);
        }
        model.addAttribute("listOfStudents", studentService.getAll());
        return "students";
    }

    @GetMapping("students/addEditItem")
    public String editForm(Model model, @RequestParam(name = "id", required = false) Long id) {
        //model.addAttribute("id", id);
        Student student;
        if (id != null) {
            student = studentService.getById(id).get();
        } else student = new Student();
        model.addAttribute("item", student);

        List<Group> groupList;
        groupList = groupService.getAll();
        model.addAttribute("groupList", groupList);

        return "studentForm";
    }

    @PostMapping("students/add")
    public String addStudent(@ModelAttribute(value = "item") Student item) {
        studentService.saveOrUpdate(item);
//        return "studentForm";
        return "redirect:/students";
    }

    @PostMapping("students/update")
    public String updateStudent(@ModelAttribute(value = "item") Student item) {

        studentService.saveOrUpdate(item);
//        return "studentForm";
        return "redirect:/students";
    }

}
