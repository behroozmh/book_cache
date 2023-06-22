package ir.behi.book_cache.controller;

import ir.behi.book_cache.model.BookDTO;
import ir.behi.book_cache.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    public BookController(BookService bookService) {
        this.service = bookService;
    }

    private final BookService service;

    @GetMapping(value = "/getList")
    public ResponseEntity<List<BookDTO>> getList() {
        return ResponseEntity.ok(service.getList());
    }

    @GetMapping(value = "/get")
    public ResponseEntity<BookDTO> get(@RequestParam(defaultValue = "-1") Integer id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PostMapping(value = "/addOrUpdate")
    public ResponseEntity<BookDTO> addOrUpdate(@RequestBody BookDTO dto) {
        return ResponseEntity.ok(service.addOrUpdate(dto));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> delete(@RequestParam(defaultValue = "-1") Integer id) {
        try {
            service.delete(id);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ResponseEntity.ok(true);
    }
}
