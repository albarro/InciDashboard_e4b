package com.uniovi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uniovi.entities.FiltroPropiedades;
import com.uniovi.entities.Incidencia;
import com.uniovi.services.FilterService;

@Controller
public class FilterController {

	@Autowired
	private FilterService filterService;
	
	@RequestMapping("/filtro/add")
	public String viewAddFilter(Model model) {
		model.addAttribute("incidence", new Incidencia());
		return "/filtro/add";
	}
	
	@RequestMapping(value="/filtro/add", method=RequestMethod.POST)
	public String addFilter(Model model, @Validated FiltroPropiedades filtro) {
		filterService.addFilter(filtro);
		return "redirect:/filtro/list";
	}
	
	@RequestMapping("/filtro/list")
	public String viewList(Model model) {
		model.addAttribute("filtros", filterService.findByLogged());
		return "/filtro/list";
	}
	
}
