package com.bolsadeideas.springboot.error.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@GetMapping({ "", "/", "/index", "/index/" })
	public String index() {

		Integer valor = 1 / 0;
		// Integer valor = Integer.parseInt("10xaaa");
		return "index";
	}

}
