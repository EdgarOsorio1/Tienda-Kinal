package com.eosorio.ProyectoTienda_in5bv.Controller;

import com.eosorio.ProyectoTienda_in5bv.Entity.Producto;
import com.eosorio.ProyectoTienda_in5bv.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productos")
public class ProductoViewController {

    @Autowired
    private ProductoRepository productoRepository;


    @GetMapping
    public String listarProductos(Model model) {
        model.addAttribute("productos", productoRepository.findAll());
        return "productos";
    }


    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("titulo", "Nuevo Producto");
        return "form-producto";
    }


    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Integer id, Model model) {
        Producto producto = productoRepository.findById(id).orElse(new Producto());
        model.addAttribute("producto", producto);
        model.addAttribute("titulo", "Editar Producto");
        return "form-producto";
    }


    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute("producto") Producto producto) {
        productoRepository.save(producto);
        return "redirect:/productos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable("id") Integer id) {
        productoRepository.deleteById(id);
        return "redirect:/productos";
    }
}