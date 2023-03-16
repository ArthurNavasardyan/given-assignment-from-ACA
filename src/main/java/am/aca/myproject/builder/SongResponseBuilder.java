package am.aca.myproject.builder;

import am.aca.myproject.dto.SongResponseDto;
import am.aca.myproject.entity.song.Song;

public class SongResponseBuilder {

    public static SongResponseDto buildSongResponseDto(Song song){
        SongResponseDto songResponseDto = new SongResponseDto();
        songResponseDto.setSongId(song.getId());
        songResponseDto.setAuthorName(song.getAuthor().getAuthorName());
        songResponseDto.setLyrics(song.getLyrics());
        songResponseDto.setTitle(song.getTitle());
        return songResponseDto;
    }

    
}
