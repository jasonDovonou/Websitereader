package com.reader.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.reader.bean.Header;
import com.reader.service.HierarchyService;

@Controller
public class ReaderController {

	@Autowired
	HierarchyService hierarchyService;
	
	@GetMapping("/reader")
	public String reader(Model model) {
		return "/reader";
	}
	 
	@GetMapping(value = "/getHierachy")
	public String getHierachy(@RequestParam String url, Model model) throws IOException {
		List<Header> headers = hierarchyService.getWebsiteHierachy(url);
		model.addAttribute("headers", headers);
		return "/reader";
	}
	
}
