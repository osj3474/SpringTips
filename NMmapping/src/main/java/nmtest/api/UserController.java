package nmtest.api;

import lombok.RequiredArgsConstructor;
import nmtest.repository.UserRepository;
import nmtest.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public List<String> getRolesById(@PathVariable Long id){
        return userService.findRolesById(id);

    }

}
