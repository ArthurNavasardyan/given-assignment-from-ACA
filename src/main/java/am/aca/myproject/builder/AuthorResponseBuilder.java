package am.aca.myproject.builder;

import am.aca.myproject.dto.AuthorResponseDto;
import am.aca.myproject.entity.song.Author;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
@Component
public class AuthorResponseBuilder {

    public AuthorResponseDto buildAuthorResponseDto(Author author) {
        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        authorResponseDto.setAuthorName(author.getAuthorName());
        authorResponseDto.setAuthorId(author.getId());
        authorResponseDto.setSongs(author
                .getSongs()
                .stream()
                .map(SongResponseBuilder::buildSongResponseDto)
                .collect(Collectors.toList()));
        return authorResponseDto;
    }

}
