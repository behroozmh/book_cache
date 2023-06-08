package ir.behi.book_cache.controller;

import ir.behi.book_cache.model.BookDTO;
import ir.behi.book_cache.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    private BookService bookService;

    @GetMapping(value = "/getList")
    public ResponseEntity getList() {
        return ResponseEntity.ok(bookService.getList());
    }

    @GetMapping(value = "/get")
    public ResponseEntity get(@RequestParam(defaultValue = "-1") Integer id) {
        return ResponseEntity.ok(bookService.get(id));
    }

    @PostMapping(value = "/addOrUpdate")
    public ResponseEntity addOrUpdate(@RequestBody BookDTO book) {
        return ResponseEntity.ok(bookService.addOrUpdate(book));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity delete(@RequestParam(defaultValue = "-1") Integer id) {
        bookService.delete(id);
        return ResponseEntity.ok(true);
    }
}
