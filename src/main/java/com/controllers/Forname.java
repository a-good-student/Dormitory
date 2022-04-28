package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Forname {
	@RequestMapping(value="/{forName}")
	public String forname(@PathVariable String forName) {
		return forName;
	}
}
