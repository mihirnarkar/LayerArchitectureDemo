package in.mindcraft.controllers;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import in.mindcraft.dao.LaptopDao;
import in.mindcraft.pojos.Laptop;

@Controller
public class LaptopController {
	
	private LaptopDao laptopDao = new LaptopDao();
	
//	Submit data :
	@RequestMapping(value = "/insertlap", method = RequestMethod.POST)
	public ModelAndView addLaptop(HttpServletRequest request,HttpServletResponse response, Model Model) throws SQLException, ClassNotFoundException {
		System.out.println("hey");
		int lid = Integer.parseInt(request.getParameter("lid"));
		String make = request.getParameter("make");
		double cost = Double.parseDouble(request.getParameter("cost"));
		
		
		Laptop laptop = new Laptop(lid,make,cost);
		
		try {
			ModelAndView mv = new ModelAndView();
			if(laptopDao.addLaptop(laptop) == true) {
				mv.setViewName("result.jsp");
				Model.addAttribute("resultmessage", "Data entered successfully");
				System.out.println("Done with success");
				return mv;
			}else {
				return mv;
			}
			
		}catch(Exception e) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("result.jsp");
			Model.addAttribute("resultmessage", "failure");
			return mv;
		}
	}
	
	
//	Get data:
	
	@RequestMapping(value = "/getdata", method = RequestMethod.GET)
	public ModelAndView getLaptop(Model Model) {
		try {
			List<Laptop> laptops = laptopDao.getAllLaptops();
			Model.addAttribute("laptops",laptops);
			ModelAndView mv = new ModelAndView();
			mv.setViewName("display.jsp");
			return mv;
		}catch(SQLException e) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("result.jsp");
			Model.addAttribute("resultmessage", "Cannot get the data");
			return mv;
		}
	}
	
	
	

}
	
		




