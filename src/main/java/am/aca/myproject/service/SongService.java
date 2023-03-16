package am.aca.myproject.service;


import am.aca.myproject.builder.SongResponseBuilder;
import am.aca.myproject.dto.SongCreateRequestDto;
import am.aca.myproject.dto.SongResponseDto;
import am.aca.myproject.entity.song.Author;
import am.aca.myproject.entity.song.Song;
import am.aca.myproject.repository.AuthorRepository;
import am.aca.myproject.repository.SongRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class SongService {

    private final AuthorRepository authorRepository;
    private  final SongRepository songRepository;
    public SongService(AuthorRepository authorRepository, SongRepository songRepository) {
        this.authorRepository = authorRepository;
        this.songRepository = songRepository;
    }


    public SongResponseDto createSong(SongCreateRequestDto songCreateRequestDto) {
        Optional<Author> author = authorRepository.findById(songCreateRequestDto.getAuthorId());
        if (author.isEmpty()){
            throw new RuntimeException("There is no existing author with that id");
        }
        Song song = new Song();
        song.setAuthor(author.get());
        song.setLyrics(songCreateRequestDto.getLyrics());
        song.setTitle(songCreateRequestDto.getTitle());
        Song saveSong = songRepository.save(song);
        return SongResponseBuilder.buildSongResponseDto(saveSong);
    }
}
