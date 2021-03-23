package com.leadership.user.rank.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.leadership.user.rank.service.BoardService;
import com.leadership.user.rank.vo.SearchResultVo;
import com.leadership.user.rank.vo.SearchVo;

@Controller
public class PageController {

	private static final Logger log = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/board",method = RequestMethod.GET)
	String home(Model model) {
		model.addAttribute("searchVo", new SearchVo());
		model.addAttribute("errMsg", Strings.EMPTY);
		return "Hello";
	}
	
	
	@RequestMapping(value="/board",method = RequestMethod.POST)
	String fetchResult(Model model,@ModelAttribute SearchVo searchVo,BindingResult result) {
		
		log.info("In fetchResult => {}",searchVo);
		List<SearchResultVo> resultVoList = new ArrayList<SearchResultVo>();
		if("topPlayers".equalsIgnoreCase(searchVo.getSearchType())) {
			log.info("fetcing top 100 players ");
			resultVoList = boardService.getTop100Players();
		}else {
			if(searchVo.getUserId() == null || searchVo.getUserId().trim().isEmpty()) {
				log.info("user id not entered");
				model.addAttribute("errMsg", "Please enter User Id.");
				model.addAttribute("result", resultVoList);
				return "Hello";
			}else {
				log.info("getting player rank");
				resultVoList = boardService.getPlayerRankByUID(searchVo.getUserId().trim());
			}
		}
		
		if(CollectionUtils.isEmpty(resultVoList)) {
			model.addAttribute("errMsg", "No result found");
		}else {
			model.addAttribute("errMsg", Strings.EMPTY);
		}
		model.addAttribute("result", resultVoList);
		
		return "Hello";
	}
}
