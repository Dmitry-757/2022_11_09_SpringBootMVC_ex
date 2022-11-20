package org.dng.springbootmvc_2022_11_09.Controllers;

import org.dng.springbootmvc_2022_11_09.Service.SubjectService;
import org.dng.springbootmvc_2022_11_09.model.Group;
import org.dng.springbootmvc_2022_11_09.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SubjectController {
    private final SubjectService service;
    private final String prefixUrl="/subjects";

    @Autowired
    public SubjectController(SubjectService service) {
        this.service = service;
    }

    @GetMapping(prefixUrl)
    public String showGroupsList(Model model) {
        model.addAttribute("listOfItems", service.getAll());
        return "subjects";
    }

    @GetMapping(prefixUrl+"/addEditItem")
    public String editForm(Model model, @RequestParam(name = "id", required = false) Long id) {
        Subject item;
        if (id != null) {
            item = service.getById(id).get();
        } else item = new Subject();
        model.addAttribute("item", item);

        return "subjectForm";
    }

    @PostMapping(prefixUrl+"/add")
    public String addItem(@ModelAttribute(value = "item") Subject item) {
        service.saveOrUpdate(item);
        return "redirect:"+prefixUrl;
    }

    @PostMapping(prefixUrl+"/update")
    public String updateGroup(@ModelAttribute(value = "item") Subject item) {

        service.saveOrUpdate(item);
        return "redirect:"+prefixUrl;
    }

    @GetMapping(prefixUrl+"/delete")
    public String removeItem(Model model, @RequestParam(name = "id") long id) {
        if (id > 0) {
            service.delete(id);
        }
        model.addAttribute("listOfItems", service.getAll());
        return "groups";
    }



}
