package com.sortNumbers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sortNumbers.model.SortedResult;
import com.sortNumbers.service.SortService;



@Controller
public class SortController {

	@Autowired
	private SortService SortService;
	
	@RequestMapping("/sort")
	@GetMapping
	public String home(@ModelAttribute("randomNumbers") String randomNumbers,ModelMap map)
	{
		SortedResult resultOfSorting = SortService.sort(randomNumbers);
		map.put("sorted", resultOfSorting.getSortedNumbers());
		map.put("Unsorted", resultOfSorting.getUnSortedNumbers());
		map.put("time", resultOfSorting.getDuration());
		map.put("swapCount", resultOfSorting.getSwapCount());
		map.put("status", resultOfSorting.getStatus());
		return "view.jsp";
	}
	
	@RequestMapping("/")
	public String home()
	{

		return "home.jsp";
	}
}

