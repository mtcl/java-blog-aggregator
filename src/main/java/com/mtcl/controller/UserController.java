package com.mtcl.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mtcl.entity.Blog;
import com.mtcl.entity.User;
import com.mtcl.service.BlogService;
import com.mtcl.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	BlogService blogService;

	@RequestMapping("/users")
	public String users(Model model) {
		model.addAttribute("users", userService.findAll());
		return "users";
	}

	@RequestMapping("/users/{id}")
	public String userDetails(Model model, @PathVariable int id) {
		model.addAttribute("user", userService.findOneWithBlogs(id));
		return "user-detail";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegister() {
		return "user-register";
	}

	// pass a Model attribute names user which will be stored in the command
	// object.
	@ModelAttribute("user")
	public User construct() {
		return new User();
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String doRegister(@ModelAttribute("user") User user) {
		userService.save(user);
		return "redirect:/register.html?success=true";
	}

	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public String account(Model model, Principal principal) {

		String name = principal.getName();
		// System.out.println("Logged in user name: " + name);
		model.addAttribute("user", userService.findOneWithBlogs(name));
		return "user-detail";
	}


	@ModelAttribute("blog")
	public Blog constructBlog() {
		return new Blog();
	}

	@RequestMapping(value = "/account", method = RequestMethod.POST)
	public String addNewBlog(@ModelAttribute("blog") Blog blog,
			Principal principal) {

		User user = userService.findByName(principal.getName());
		blogService.save(blog, user);
		return "redirect:/account.html";
	}

}
