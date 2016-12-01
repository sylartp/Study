package com.GrappleGame.Web.Controller;

import com.GrappleGame.Web.POJO.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by tppppp on 2016/12/1.
 */
@Controller
@RequestMapping(value = "/")
public class UserController {

    @RequestMapping(value = "/Login", method = RequestMethod.GET)
    public String Login() {
        return "Login";
    }

    @RequestMapping(value = "/Login", method = RequestMethod.POST)
    public String Show(User user , Model model) {
        model.addAttribute("user",user);
        return "Show";
    }
}
