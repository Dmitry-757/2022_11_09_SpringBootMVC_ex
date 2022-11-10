package org.dng.springbootmvc_2022_11_09.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/")
public class StartController {


    @GetMapping("/start")
    public String getHelloPage(Model model, @RequestParam(value = "name") String name){
        model.addAttribute("name", name);

        return "start";
    }
}
