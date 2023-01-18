package ok.team.accreftoken.repo;

import ok.team.accreftoken.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Oybek Karimjanov
 * Date : 1.17.2023
 * Project Name : accreftoken
 */
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
