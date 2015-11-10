package cs544.exercise9;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/books")
public class BookController {

	@Resource
	private IBookDao bookDao;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("books", bookDao.getAll());
		return "book/bookList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addNewBook(@ModelAttribute("book") Book book) {
		return "book/addUpdateBook";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ExceptionHandler(NumberFormatException.class)
	public String addPostBook(@Valid Book book, BindingResult result) {
		if (!result.hasErrors()) {
			bookDao.add(book);
			return "redirect:/books";
		} else {
			return "book/addUpdateBook";
		}
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String updateBook(@PathVariable int id, Model model) {
		model.addAttribute("book", bookDao.get(id));
		return "book/addUpdateBook";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String updatePostBook(@Valid Book book, BindingResult result, @PathVariable int id) {
		if (!result.hasErrors()) {
			bookDao.update(id, book);
			return "redirect:/books";
		} else {
			return "book/addUpdateBook";
		}
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable int id) {
		bookDao.delete(id);
		return "redirect:/books";
	}

	// Handles date format
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
