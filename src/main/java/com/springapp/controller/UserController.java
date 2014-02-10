package com.springapp.controller;

import com.springapp.entitys.User;
import com.springapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
public class UserController {

    private User databaseUser;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getList(@ModelAttribute @Valid User user, BindingResult result, ModelMap model) {
        model.addAttribute("header_title", "welcome to user accounts page.");
        model.addAttribute("userList", userService.getAll());
        return "users_list";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public /*RedirectView*/ ModelAndView add(@ModelAttribute @Valid User user, BindingResult result, ModelAndView modelAndView) {
        if (result.hasErrors()) {
            //i don`t now how to return my start page with users list and errors
            modelAndView.setViewName("users_list");
            return modelAndView;
//            return new RedirectView("/SimpleMVC/users");
        }
        try {
            databaseUser = userService.findByUsername(user.getUsername());
            compareDataFields(user);
            userService.update(databaseUser);
        } catch (NullPointerException ex) {
            userService.add(user);
        } finally {
            return modelAndView;
//            return new RedirectView("/SimpleMVC/users");
        }
    }

    @RequestMapping(value = "/users/delete", method = RequestMethod.GET)
    public RedirectView delete(@ModelAttribute User user, ModelMap map) {
        userService.delete(user);
        return new RedirectView("/SimpleMVC/users");
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