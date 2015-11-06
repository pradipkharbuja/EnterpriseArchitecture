package cs544.exercise9;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/books")
public class BookController {

	@Resource
	private IBookDao bookDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("books", bookDao.getAll());
		return "book/bookList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addNewBook() {
		return "book/addBook";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addPostBook(Book book) {
		bookDao.add(book);
		return "redirect:/books/";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String updateBook(@PathVariable int id, Model model) {
		model.addAttribute("book", bookDao.get(id));
		return "book/updateBook";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String updatePostBook(Book book, @PathVariable int id) {
		bookDao.update(id, book);
		return "redirect:/books/";
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable int id) {
		bookDao.delete(id);
		return "redirect:/books/";
	}
}
