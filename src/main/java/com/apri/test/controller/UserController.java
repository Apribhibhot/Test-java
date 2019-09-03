package com.apri.test.controller;

import com.apri.test.entity.User;
import com.apri.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;


import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    @RequestMapping(path = "/login")
    public String  formLogin(){
        return "login/login";
    }
        @RequestMapping(path = "/aksilogin", method = RequestMethod.GET)
    public String  login(Model model, @ModelAttribute("loginBean") User loginBean){
        System.out.println("user : "+loginBean.getUsername());
        System.out.println("pass : "+loginBean.getPassword());

//        model.addAttribute("dataUser", userService.findAll());
//        List<User> login = userService.findByUsernameAndPassword(loginBean);

        if (loginBean != null && loginBean.getUsername() != null & loginBean.getPassword() != null) {

            if (loginBean.getUsername().equals("admin") && loginBean.getPassword().equals("admin123")) {
                model.addAttribute("msg", loginBean.getUsername());
                System.out.println("yihaaa!!");
                return "redirect:/mahasiswa";
            } else {
                model.addAttribute("error", "Invalid Cred");
//                System.out.println("salah");
                return "login/login";
            }
        } else {
            model.addAttribute("error", "Invalid");
//            System.out.println("gas!");
            return "login/login";
        }
    }
    
    @GetMapping(path = "/create")
    public String viewCreate(Model model) {
        model.addAttribute("dataSets", new User());
        return "/user/create";
    }

    @GetMapping(path = "/update/{id}")
    public String viewUpdate(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("dataSets", userService.findById(id));
        return "/user/update";
    }

    @PostMapping(value = "/create")
    public String save(User param) {
        User data = userService.save(param);
        if (data.getId() == 0) {
            return "redirect:/user/create?failed";
        } else {
            return "redirect:/user/create?success";
        }
    }

    @PutMapping(path = "/update")
    public String update(User param) {
        User data = userService.update(param);
        if (data.getId() == 0) {
            return "redirect:/user?ufailed";
        } else {
            return "redirect:/user?usuccess";
        }
    }

    @DeleteMapping(path = "/delete")
    public String delete(User param) {
        int data = userService.delete(param);
        if (data == 0) {
            return "redirect:/user?dfailed";
        } else {
            return "redirect:/user?dsuccess";
        }
    }

    @GetMapping(path = "")
    public String viewData(Model model,
                           @RequestParam(value = "search", required = false) String param,
                           @RequestParam(value = "filter", required = false) String param1) {
        if (param == null && param1 == null) {
            model.addAttribute("dataSets", userService.findAll());
        } else {
            User user = new User();
            user.setUsername(param);
            model.addAttribute("dataSets", userService.findByUsername(user));
        }
        return "/user/list";
    }


}
