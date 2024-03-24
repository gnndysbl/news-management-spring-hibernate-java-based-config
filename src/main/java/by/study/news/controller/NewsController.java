package by.study.news.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import by.study.news.entity.Article;
import by.study.news.service.NewsService;
import by.study.news.service.exception.ServiceException;

@Controller

public class NewsController {

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

	}

	// need to inject our news service
	@Autowired
	private NewsService newsService;

	@RequestMapping("/showMainPage")
	public String showMainPage(Model model) {

		// get news from the service
		List<Article> news = newsService.getActive();

		// add the news to the model
		model.addAttribute("news", news);

		return "pages/main";

	}

	@GetMapping("/showAddArticlePage")
	public String showAddArticlePage(Model model) {

		// create model attribute to bind form data
		Article article = new Article();

		model.addAttribute("article", article);

		return "pages/articleAdd";
	}

	@GetMapping("/showEditArticlePage")
	public String showEditArticlePage(@RequestParam("id") int id, Model model) throws ServiceException {

		// create model attribute to bind form data
		Article article = newsService.get(id);

		model.addAttribute("article", article);

		return "pages/articleAdd";
	}

	@PostMapping("/saveArticle")
	public String saveArticle(@Valid @ModelAttribute("article") Article theArticle, BindingResult theBindingResult) {

		// save the article using our service

		if (theBindingResult.hasErrors()) {
			return "pages/articleAdd";
		} else {
			newsService.save(theArticle);
			return "redirect:/showArticle?id=" + theArticle.getId();
		}

	}

	@GetMapping("/deleteArticle")
	public String blockArticle(@RequestParam("id") int Id) {

		// delete the article
		newsService.block(Id);

		return "redirect:/showMainPage";
	}

	@GetMapping("/showArticle")
	public String showArticle(@RequestParam("id") int id, Model model) throws ServiceException {

		// get the article from our service

		Article article = newsService.get(id);

		// set article as a model attribute
		model.addAttribute("article", article);

		// send over

		return "pages/articleView";

	}
}