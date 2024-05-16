package ma.dentiste.app.Respository;

import ma.dentiste.app.entites.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
