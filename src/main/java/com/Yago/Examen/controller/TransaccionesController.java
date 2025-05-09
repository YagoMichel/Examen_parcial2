package com.Yago.Examen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Yago.Examen.model.TransaccionesModel;
import com.Yago.Examen.services.TransaccionesServices;

@Controller
public class TransaccionesController {
    @Autowired
    private TransaccionesServices transaccionesServices;

    @GetMapping("/transacciones")
    public String products(Model model) {
        List<TransaccionesModel> productos = transaccionesServices.findAll();
        model.addAttribute("productos", productos);
        return "transaccion/transacciones_list";
    }

    @GetMapping("/products/new")
    public String mostrarFormularioProduct(Model model) {
        ProductModel producto = new ProductModel();
        model.addAttribute("producto", producto);
        return "agregar-producto";
    }

    @PostMapping("/products/guardar")
    public String guardarProducto(@ModelAttribute ProductModel producto) {
        productService.save(producto);
        return "redirect:/products";
    }

    @GetMapping("/products/delete/{id}")
    public String mostrarFormularioEliminarProducto(@PathVariable int id,
                                                    Model model) {
        ProductModel producto = productService.findById(id);
        model.addAttribute("producto", producto);
        return "eliminar-producto";
    }

    @PostMapping("/products/delete")
    public String eliminarProducto(@ModelAttribute ProductModel producto) {
        productService.delete(producto.getId());
        return "redirect:/products";
    }

    @GetMapping("/products/edit/{id}")
    public String mostrarFormularioEditarProducto(@PathVariable int id,
                                                  Model model) {
        ProductModel producto = productService.findById(id);
        model.addAttribute("producto", producto);
        return "editar-producto";
    }

    @PostMapping("/products/edit")
    public String editarProducto(@ModelAttribute ProductModel producto) {
        productService.update(producto);
        return "redirect:/products";
    }

}
