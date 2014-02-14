package com.springapp.controller;

import com.springapp.entitys.User;
import com.springapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/main")
public class UserController {

    private User databaseUser;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String getMainPage(@ModelAttribute @Valid User user, BindingResult result, ModelMap model) {
        model.addAttribute("header_title", "welcome to user accounts page.");
        return "main";
    }

    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public String getUserList(Model model) {
        model.addAttribute("userList", userService.getAll());
        return "user_list";
    }

    @RequestMapping()
    public String addUser(@ModelAttribute @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            //TODO refresh add jsp to view result of field validation
            return "redirect:/main";
        }
        try {
            databaseUser = userService.findByUsername(user.getName());
            compareDataFields(user);
            userService.update(databaseUser);
        } catch (NullPointerException ex) {
            userService.add(user);
        } finally {
            return "redirect:/main";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public RedirectView deleteUser(@ModelAttribute User user, Model model) {
        userService.delete(user);
        return new RedirectView("/SimpleMVC/main");
    }

    private void compareDataFields(User inputUser) {
        if (!databaseUser.getPassword().equals(inputUser.getPassword())) {
            databaseUser.setPassword(inputUser.getPassword());
        }
        if (!databaseUser.getEmail().equals(inputUser.getEmail())) {
            databaseUser.setEmail(inputUser.getEmail());
        }
    }

}