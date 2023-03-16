package am.aca.myproject.controller;

import am.aca.myproject.dto.SongCreateRequestDto;
import am.aca.myproject.dto.SongResponseDto;
import am.aca.myproject.service.SongService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/song")
public class SongController {

    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }
    @PostMapping
    public SongResponseDto createSong(@RequestBody SongCreateRequestDto songCreateRequestDto){
        return songService.createSong(songCreateRequestDto);
    }


}
