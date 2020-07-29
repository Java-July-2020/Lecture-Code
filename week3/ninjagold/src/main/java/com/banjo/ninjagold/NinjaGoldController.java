package com.banjo.ninjagold;

import java.security.Timestamp;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NinjaGoldController {
	@RequestMapping("/")
	public String gold(HttpSession session, Model model) {
		if (session.isNew()) {
			reset(session);
		}
		model.addAttribute("activityLog", session.getAttribute("activityLog"));
		model.addAttribute("totalGold", session.getAttribute("totalGold"));
		return "index.jsp";
	}
	
	private void reset(HttpSession session) {
		session.setAttribute("totalGold", 0);
		ArrayList<String> activityList = new ArrayList<String>();
		session.setAttribute("activityLog", activityList);
		
	}
	
	@RequestMapping(value="/activity", method=RequestMethod.POST)
		public String getgold(@RequestParam(value="building") String building, HttpSession session) {
		int gold = (int)session.getAttribute("totalGold");
		Random r = new Random();
		
		@SuppressWarnings("unchecked")
		ArrayList<String> activities = (ArrayList<String>)session.getAttribute("activityLog");
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd YYYY h:mma");
		System.out.println(building.equals("farm"));
		System.out.println(building);
		if (building.equals("farm")) {
			int farmgold = r.nextInt((20 - 10) + 1) + 10;
			gold += farmgold;
			session.setAttribute("totalGold", gold);
			activities.add("You entered a farm and earned " + farmgold + " gold! " + "(" + formatter.format(now) + ")");
			}
		if (building.equals("cave")) {
			int cavegold = r.nextInt((10 - 5) + 1) + 5;
			gold += cavegold;
			session.setAttribute("totalGold", gold);
			activities.add("You entered a cave and earned " + cavegold + " gold! " + "(" + formatter.format(now) + ")");
			}
		if (building.equals("house")) {
			int housegold = r.nextInt((5 - 2) + 1) + 2;
			gold += housegold;
			session.setAttribute("totalGold", gold);
			activities.add("You entered a house and earned " + housegold + " gold! " + "(" + formatter.format(now) + ")");
			}
		if (building.equals("casino")) {
			int casinogold = r.nextInt((50 + 50) + 1) - 50;
			if (casinogold < 0) {
				activities.add("You entered a casino and lost " + casinogold + " gold! Ouch " + "(" + formatter.format(now) + ")");
			} else {
				activities.add("You entered a casino and won " + casinogold + " gold! " + "(" + formatter.format(now) + ")");
			}
			gold += casinogold;
			session.setAttribute("totalGold", gold);
		}
		if (building.equals("spa")) {
			int spagold = r.nextInt((20 - 5) + 1) - 20;
				activities.add("You feel relaxed from a spa day but spent " + spagold + " gold! Ouch " + "(" + formatter.format(now) + ")");			
			gold += spagold;
			session.setAttribute("totalGold", gold);
		}
		
		System.out.println(activities);
			return "redirect:/";
		}
}
