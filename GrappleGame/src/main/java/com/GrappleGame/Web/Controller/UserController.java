package com.GrappleGame.Web.Controller;

import com.GrappleGame.Web.POJO.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


/**
 * Created by tppppp on 2016/12/1.
 */
@Controller
@RequestMapping(value = "/")
public class UserController {

    @RequestMapping(value = "/Login", method = RequestMethod.GET)
    public String Login(Model model) {
        model.addAttribute(new User());
        return "Login";
    }

    @RequestMapping(value = "/Login", method = RequestMethod.POST)
    public String Show(@Valid User user, BindingResult result, Model model) {
        System.out.print(result.hasErrors());
        if(result.hasErrors()){
            return "Login";
        }
        model.addAttribute("user", user);
        return "Show";
    }
}
