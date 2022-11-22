package org.dng.springbootmvc_2022_11_09.Controllers;

import org.dng.springbootmvc_2022_11_09.Service.MarkService;
import org.dng.springbootmvc_2022_11_09.Service.StudentService;
import org.dng.springbootmvc_2022_11_09.Service.SubjectService;
import org.dng.springbootmvc_2022_11_09.model.Mark;
import org.dng.springbootmvc_2022_11_09.model.Student;
import org.dng.springbootmvc_2022_11_09.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class MarkController {
    private final StudentService studentService;
    private final MarkService markService;
    private final SubjectService subjectService;
    private final String prefix = "/marks";

    @Autowired
    public MarkController(StudentService studentService, MarkService markService, SubjectService subjectService) {
        this.studentService = studentService;
        this.markService = markService;
        this.subjectService = subjectService;
    }

//    @GetMapping("/start")
//    public String getHelloPage() {
//        return "start";
//    }

    @GetMapping(prefix)
    public String showItemstsList(Model model) {
        model.addAttribute("listOfItems", markService.getAll());
        return "marks";
    }

    @GetMapping(prefix + "/addEditItem")
    public String editForm(Model model, @RequestParam(name = "id", required = false) Long id,
                           @RequestParam(name = "date", required = false) String strDate,
                           @RequestParam(name = "message", required = false) String message
                           ) {
        Mark item;
        if (id != null) {
            item = markService.getById(id).get();
        } else {
            item = new Mark();
            if (strDate != null) {
                item.setDate(LocalDate.parse(strDate));
            }
        }

        model.addAttribute("item", item);

        List<Student> studentsList = studentService.getAll();
        model.addAttribute("studentsList", studentsList);

        List<Subject> subjectList = subjectService.getAll();
        model.addAttribute("subjectList", subjectList);

        if (message!=null){
            model.addAttribute("message", message);
        }

        return "markForm";
    }

    @PostMapping(prefix + "/add")
    public String add(Model model, @ModelAttribute(value = "item") @Valid Mark item, BindingResult bindingResult) {
//        if (item.getMark() > 0) {
//            markService.saveOrUpdate(item);
//            return "redirect:" + prefix;
//        }
//        String message = "Need to fill all parameters properly!";
//        return "redirect:" + prefix + "/addEditItem?date=" + item.getDate()+"&message="+message;
        if(bindingResult.hasErrors()){
            model.addAttribute("item", item);

            List<Student> studentsList = studentService.getAll();
            model.addAttribute("studentsList", studentsList);

            List<Subject> subjectList = subjectService.getAll();
            model.addAttribute("subjectList", subjectList);

            return "markForm";
        }
            markService.saveOrUpdate(item);
            return "redirect:" + prefix;
    }

    @PostMapping(prefix + "/update")
    public String update(Model model, @ModelAttribute(value = "item") @Valid Mark item, BindingResult bindingResult) {
//        if (item.getMark() > 0) {
//            markService.saveOrUpdate(item);
//            return "redirect:" + prefix;
//        }
//        String message = "Need to fill all parameters properly!";
//        return "redirect:" + prefix + "/addEditItem?date=" + item.getDate()+"&id="+item.getId()+"&message="+message;
        if(bindingResult.hasErrors()){
            model.addAttribute("item", item);

            List<Student> studentsList = studentService.getAll();
            model.addAttribute("studentsList", studentsList);

            List<Subject> subjectList = subjectService.getAll();
            model.addAttribute("subjectList", subjectList);

            return "markForm";
        }
        markService.saveOrUpdate(item);
        return "redirect:" + prefix;
    }

    @GetMapping(prefix + "/delete")
    public String remove(Model model, @RequestParam(name = "id") long id) {
        if (id > 0) {
            markService.delete(id);
        }
        model.addAttribute("listOfStudents", studentService.getAll());
        return "students";
    }


}
