package ok.team.accreftoken.repo;

import ok.team.accreftoken.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Oybek Karimjanov
 * Date : 1.17.2023
 * Project Name : accreftoken
 */
public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
