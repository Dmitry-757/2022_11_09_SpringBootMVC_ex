package org.dng.springbootmvc_2022_11_09.Controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
//import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MyErrorController implements ErrorController {
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        //do something like logging
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
//        String errMessage = RequestDispatcher.ERROR_MESSAGE.toString();
        String errMessage = "Check url!";

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            model.addAttribute("status", statusCode);
            model.addAttribute("errMessage", errMessage);

//            if(statusCode == HttpStatus.NOT_FOUND.value()) {
//                return "error-404";
//            }
//            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
//                return "error-500";
//            }
        }
        return "error-page";
    }

}
