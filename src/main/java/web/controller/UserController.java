package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.showAllUsers());
        return "/all_users";
    }

    @GetMapping("/make_new_empty")
    public String emptyUser(@ModelAttribute("user") User user) {
        return "/empty_to_fill_in";
    }

    @PostMapping("/brand_new_user")
    public String newUser(User user) {
        userService.newUser(user);
        return "redirect:/users";
    }

    @GetMapping("/get_user_to_edit/{id}")
    public String userToBeEdited(@PathVariable("id") Long id, Model model) {
        User user = userService.showUser(id);
        model.addAttribute("user", user);
        return "/edit_this_user";
    }

    @PutMapping ("/updated_user")
    public String editUser(@ModelAttribute("user") User user) {
        userService.editUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/delete_user/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}