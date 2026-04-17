package com.eosorio.ProyectoTienda_in5bv.Controller;

import com.eosorio.ProyectoTienda_in5bv.Entity.Usuario;
import com.eosorio.ProyectoTienda_in5bv.Service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @GetMapping("/get")
    public List<Usuario> listar(){
        return usuarioService.listar();
    }

    @GetMapping("/{Id}")
    public Usuario obtener(@PathVariable Integer Id){

        return usuarioService.obtnerePorId(Id);
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario crear(@RequestBody Usuario usuario){
        return usuarioService.crear(usuario);
    }

    @PutMapping("/put/{Id}")
    public Usuario actualizar(@RequestBody Integer Id,@RequestBody Usuario usuario){
        return usuarioService.actualizar(Id,usuario);
    }

    @DeleteMapping("/{Id}")
    public Usuario eliminar(@PathVariable Integer Id){
        usuarioService.eliminar(Id);
        return null;
    }

}
