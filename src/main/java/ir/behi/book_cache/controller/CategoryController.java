package ir.behi.book_cache.controller;

import ir.behi.book_cache.model.CategoryDTO;
import ir.behi.book_cache.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    public CategoryController(CategoryService categoryService) {
        this.service = categoryService;
    }

    private final CategoryService service;

    @GetMapping(value = "/getList")
    public ResponseEntity<List<CategoryDTO>> getList() {
        return ResponseEntity.ok(service.getList());
    }

    @GetMapping(value = "/get")
    public ResponseEntity<CategoryDTO> get(@RequestParam(defaultValue = "-1") Integer id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PostMapping(value = "/addOrUpdate")
    public ResponseEntity<CategoryDTO> addOrUpdate(@RequestBody CategoryDTO dto) {
        return ResponseEntity.ok(service.addOrUpdate(dto));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> delete(@RequestParam(defaultValue = "-1") Integer id) {
        service.delete(id);
        return ResponseEntity.ok(true);
    }
}
