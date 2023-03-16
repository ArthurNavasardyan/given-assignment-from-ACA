package am.aca.myproject.controller;


import am.aca.myproject.dto.AuthorCreateRequestDto;
import am.aca.myproject.dto.AuthorResponseDto;
import am.aca.myproject.service.AuthorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public AuthorResponseDto createAuthor(@RequestBody AuthorCreateRequestDto authorCreateRequestDto) {
        return authorService.createAuthor(authorCreateRequestDto);
    }


}
