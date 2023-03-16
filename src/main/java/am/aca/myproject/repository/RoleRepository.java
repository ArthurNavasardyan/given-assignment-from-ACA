package am.aca.myproject.repository;

import am.aca.myproject.entity.song.ERole;
import am.aca.myproject.entity.song.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);

}
