package com.eosorio.ProyectoTienda_in5bv.Controller;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    private final InMemoryUserDetailsManager inMemoryUserDetailsManager;
    private final PasswordEncoder passwordEncoder;

    // Inyectamos los Beans creados en SecurityConfig
    public RegisterController(InMemoryUserDetailsManager inMemoryUserDetailsManager, PasswordEncoder passwordEncoder) {
        this.inMemoryUserDetailsManager = inMemoryUserDetailsManager;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping("/register")
    public String processRegistration(@RequestParam("username") String username,
                                      @RequestParam("password") String password,
                                      Model model) {

        // Verificamos si el usuario ya existe en memoria
        if (inMemoryUserDetailsManager.userExists(username)) {
            model.addAttribute("error", "El nombre de usuario ya está en uso.");
            return "register";
        }

        // Creamos el nuevo usuario y lo encriptamos
        UserDetails newUser = User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .roles("USER") // Rol por defecto
                .build();

        // Guardamos el usuario en memoria
        inMemoryUserDetailsManager.createUser(newUser);


        return "redirect:/login?registered";
    }
}
