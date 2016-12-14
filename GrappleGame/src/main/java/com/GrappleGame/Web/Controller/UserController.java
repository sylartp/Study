package com.GrappleGame.Web.Controller;

import com.GrappleGame.Web.Exception.TestException;
import com.GrappleGame.Web.POJO.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


/**
 * Created by tppppp on 2016/12/1.
 */
@Controller
@RequestMapping("/")
public class UserController {

    @RequestMapping(value = "/Login", method = RequestMethod.GET)
    public String Login(Model model) {
        User user = new User();
        model.addAttribute(user);
//        user =null;
//        if(user==null){
//            throw  new TestException();
//        }
        return "Login";
    }


    @RequestMapping(value = "/Login", method = RequestMethod.POST)
    public String Show(User user, Model model, @RequestPart("profilePicture") MultipartFile profilePicture) throws IOException {
        String path = this.getClass().getResource("/data/").toString();
        path = path.substring(path.indexOf('/'));
        System.out.print(path);
        user.setPictureName(profilePicture.getOriginalFilename());
        user.setPath(path + profilePicture.getOriginalFilename());
        model.addAttribute("user", user);
        profilePicture.transferTo(new File("/Users/tppppp/Documents/Study/GrappleGame/src/main/webapp/data/"
                + profilePicture.getOriginalFilename()));
        return "Show";
    }
}
