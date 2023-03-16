package am.aca.myproject.service;

import am.aca.myproject.builder.AuthorResponseBuilder;
import am.aca.myproject.dto.AuthorCreateRequestDto;
import am.aca.myproject.dto.AuthorResponseDto;
import am.aca.myproject.entity.song.Author;
import am.aca.myproject.repository.AuthorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorResponseBuilder authorResponseBuilder;

    public AuthorService(AuthorRepository authorRepository, AuthorResponseBuilder authorResponseBuilder) {
        this.authorRepository = authorRepository;
        this.authorResponseBuilder = authorResponseBuilder;
    }

    public AuthorResponseDto createAuthor(AuthorCreateRequestDto authorCreateRequestDto) {
        authorRepository.findAll().stream().map(el -> {
            if (el.getAuthorName().equals(authorCreateRequestDto.getAuthorName())) {
                throw new RuntimeException("the author of this exists");
            }
            return el;
        }).collect(Collectors.toList());
        Author author = new Author();
        author.setAuthorName(authorCreateRequestDto.getAuthorName());
        author.setSongs(new ArrayList<>());
        Author saveAuthor = authorRepository.save(author);
        return authorResponseBuilder.buildAuthorResponseDto(saveAuthor);
    }

}


