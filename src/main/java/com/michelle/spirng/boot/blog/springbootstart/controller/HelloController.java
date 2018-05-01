package com.michelle.spirng.boot.blog.springbootstart.controller;

import com.michelle.spirng.boot.blog.springbootstart.domain.User;
import com.michelle.spirng.boot.blog.springbootstart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping(value = "/user")
public class HelloController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 用户列表页面
     * @param model
     * @return
     */
    @GetMapping
    public String list(Model model){
        model.addAttribute("users",userRepository.findAll());
        model.addAttribute("title", "用户管理");
        return "user/list";
    }

    /**
     * 根据ID查看用户页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("{id}")
    public String view(@PathVariable("id") Long id, Model model){
        User user = userRepository.findById(id).get();
        model.addAttribute("user",user);
        model.addAttribute("title","查看用户");
        return "user/view";
    }

    /**
     * 创建用户表单的页面
     * @param model
     * @return
     */
    @GetMapping("/form")
    public String createForm(Model model){
        model.addAttribute("user",new User(null,null,null));
        model.addAttribute("title","创建用户");
        return "user/form";
    }

    /**
     * 保存或者更新用户
     * @param user
     * @return
     */
    @PostMapping
    public String save(User user){
        userRepository.save(user);
        return "redirect:/user";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id,Model model){
        User user = userRepository.findById(id).get();
        model.addAttribute("user",user);
        model.addAttribute("title","修改用户");
        return "user/form";
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @GetMapping("/del/{id}")
    public String delete(@PathVariable("id") Long id){
        userRepository.deleteById(id);
        return "redirect:/user";
    }

}
