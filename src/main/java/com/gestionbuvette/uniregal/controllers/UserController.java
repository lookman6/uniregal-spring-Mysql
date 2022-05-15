package com.gestionbuvette.uniregal.controllers;

import com.gestionbuvette.uniregal.models.User;
import com.gestionbuvette.uniregal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String findAll(Model model){
        model.addAttribute("users", userService.findAll());
        return "user";
    }
    //Modified method to Add a new user User
    @PostMapping(value="/users/addNewR")
    public RedirectView addNew(User user, RedirectAttributes redir) {
        userService.save(user);
        RedirectView  redirectView= new RedirectView("/login",true);
        redir.addFlashAttribute("message",
                "Vous vous êtes inscrit avec succès! Vous pouvez maintenant vous connecter.");
        return redirectView;
    }
    @PostMapping(value="/users/addNew")
    public String addNew(User user){
        userService.save(user);
        return "redirect:/users";
    }
    @RequestMapping("/users/findById")
    @ResponseBody
    public Optional<User> findById(int id)
    {
        return userService.findById(id);
    }

    @RequestMapping(value="/users/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(User user) {
        userService.save(user);
        return "redirect:/users";
    }
    @RequestMapping(value="/users/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        userService.delete(id);
        return "redirect:/users";
    }
}