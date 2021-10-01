package com.bolsadeideas.springboot.error.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bolsadeideas.springboot.error.app.errors.UserNotFoundException;
import com.bolsadeideas.springboot.error.app.models.domain.User;
import com.bolsadeideas.springboot.error.app.services.UserService;

@Controller
public class AppController {

	@Autowired
	private UserService userService;

	@SuppressWarnings("unused")
	@GetMapping({ "", "/", "/index", "/index/" })
	public String index() {

		Integer valor = 1 / 0;
		// Integer valor = Integer.parseInt("10xaaa");

		return "index";
	}

	@GetMapping("/see/{id}")
	public String see(@PathVariable Integer id, Model model) {

		User user = this.userService.findByIdOptional(id).orElseThrow(() -> new UserNotFoundException(id.toString()));

		model.addAttribute("title", String.format("Detalle del usuario: %s", user.getName()));
		model.addAttribute("user", user);

		return "see";
	}

}
