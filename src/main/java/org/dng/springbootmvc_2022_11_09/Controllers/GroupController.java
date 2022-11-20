package org.dng.springbootmvc_2022_11_09.Controllers;

import org.dng.springbootmvc_2022_11_09.Service.GroupService;
import org.dng.springbootmvc_2022_11_09.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller()
public class GroupController {

    private final GroupService groupService;
    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/groups")
    public String showGroupsList(Model model) {
        model.addAttribute("listOfItems", groupService.getAll());
        return "groups";
    }

    @GetMapping("groups/addEditItem")
    public String editForm(Model model, @RequestParam(name = "id", required = false) Long id) {
        Group item;
        if (id != null) {
            item = groupService.getById(id).get();
        } else item = new Group();
        model.addAttribute("item", item);

        return "groupForm";
    }

    @PostMapping("groups/add")
    public String addItem(@ModelAttribute(value = "item") Group item) {
        groupService.saveOrUpdate(item);
        return "redirect:/groups";
    }

    @PostMapping("groups/update")
    public String updateGroup(@ModelAttribute(value = "item") Group item) {

        groupService.saveOrUpdate(item);
        return "redirect:/groups";
    }

    @GetMapping("groups/delete")
    public String removeItem(Model model, @RequestParam(name = "id") long id) {
        if (id > 0) {
            groupService.delete(id);
        }
        model.addAttribute("listOfItems", groupService.getAll());
        return "groups";
    }


}
