package am.aca.myproject.repository;

import am.aca.myproject.entity.song.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface SongRepository extends JpaRepository<Song,Long> {

    Song findByTitle(String title);


    Song save(Song song);

}
