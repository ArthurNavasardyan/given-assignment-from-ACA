package am.aca.myproject.dto;

import am.aca.myproject.entity.song.Song;

import java.util.List;

public class AuthorResponseDto {

    private Long authorId;
    private String authorName;

    private List<SongResponseDto> songs;

    public Long getAuthorId() {return authorId;}

    public void setAuthorId(Long authorId) {this.authorId = authorId;}

    public String getAuthorName() {return authorName;}

    public void setAuthorName(String authorName) {this.authorName = authorName;}

    public List<SongResponseDto> getSongs() {return songs;}

    public void setSongs(List<SongResponseDto> songs) {this.songs = songs;}
}
