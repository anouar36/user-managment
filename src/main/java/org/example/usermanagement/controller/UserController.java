    package org.example.usermanagement.controller;

    import lombok.AllArgsConstructor;
    import org.example.usermanagement.entity.User;
    import org.example.usermanagement.service.UserService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    import java.util.Optional;

    @RestController
    @RequestMapping("/api/users")
    @AllArgsConstructor
    public class UserController {
        @Autowired
        private final UserService userService;

        @GetMapping
        public List<User> getAllUsers(){
            return userService.getAllUsers();
        }

        @GetMapping("/{id}")
        public User findById(@PathVariable("id") Long id) {
            return userService.findById(id)
                    .orElseThrow(() -> new RuntimeException("User not found"));
        }

        @PostMapping
        public User save(@RequestBody User user)    {
            return userService.save(user);
        }

        @PutMapping("/{id}")
        public User update(@PathVariable("id")  Long id, @RequestBody User user) {
            return userService.update(id, user);
        }

        @DeleteMapping("/{id}")
        public void delete(@PathVariable Long id) {
            userService.deleteById(id);
        }






    }
