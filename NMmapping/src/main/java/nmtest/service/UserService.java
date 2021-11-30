package nmtest.service;

import lombok.RequiredArgsConstructor;
import nmtest.domain.Role;
import nmtest.repository.UserRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<String> findRolesById(Long id){
        return userRepository.findRolesById(id);
    }
}
