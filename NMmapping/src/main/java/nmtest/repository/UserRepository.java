package nmtest.repository;

import nmtest.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
//    @Query("SELECT p FROM Like l JOIN l.product p WHERE l.user.userId=:id ORDER BY p.uploadDate DESC")
//    List<Product> findLikedProducts(@Param("id") Long id);

    @Query("select r.name from Role r where r.id in " +
            "(select ur.role.id from UserRole ur where ur.user.id = :id)")
    List<String> findRolesById(@Param("id") Long id);






//    select `name` from `role` r
//    where r.id in (select roles_id from user_roles where user_id =4);
}
