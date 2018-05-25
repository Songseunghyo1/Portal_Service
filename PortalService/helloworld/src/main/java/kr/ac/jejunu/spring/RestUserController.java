package kr.ac.jejunu.spring;

import kr.ac.jejunu.hello.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rest")
public class RestUserController {
    @GetMapping("{id}")
    @ResponseBody
    public User get(@PathVariable Integer id) {
        User user = new User();
        user.setId(id);
        user.setName("hulk");
        user.setPassword("1111");

        return user;
    }
}
