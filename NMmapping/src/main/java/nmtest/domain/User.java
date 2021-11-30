package nmtest.domain;

import lombok.Getter;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@NoRepositoryBean
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "user")
    private List<UserRole> userRoles;

}

