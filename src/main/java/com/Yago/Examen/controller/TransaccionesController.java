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
    public String transaccion(Model model) {
        List<TransaccionesModel> transacciones = transaccionesServices.findAll();
        model.addAttribute("transacciones", transacciones);
        return "transaccion/transacciones_list";
    }

    @GetMapping("/transacciones/nuevo")
    public String mostrarFormularioTransaccion(Model model) {
        TransaccionesModel transaccion = new TransaccionesModel();
        model.addAttribute("transaccion", transaccion);
        return "transaccion/transacciones_add";
    }

    @PostMapping("/transacciones/guardar")
    public String guardarTransaccion(@ModelAttribute TransaccionesModel 
                                    transaccion) {
        transaccionesServices.save(transaccion);
        return "redirect:/transacciones";
    }

    @GetMapping("/transacciones/delete/{id}")
    public String mostrarFormularioEliminarTransaccion(@PathVariable int id,
                                                    Model model) {
        TransaccionesModel transaccion = transaccionesServices.findById(id);
        model.addAttribute("transaccion", transaccion);
        return "transaccion/transacciones_del";
    }

    @PostMapping("/transacciones/delete")
    public String eliminarTransaccion(@ModelAttribute TransaccionesModel transaccion) {
        transaccionesServices.delete(transaccion.getId());
        return "redirect:/transacciones";
    }

    @GetMapping("/transacciones/edit/{id}")
    public String mostrarFormularioEditarTransaccion(@PathVariable int id,
                                                Model model) {
        TransaccionesModel transaccion = transaccionesServices.findById(id);
        model.addAttribute("transaccion", transaccion);
        return "transaccion/transacciones_edit";
    }

    @PostMapping("/transacciones/edit")
    public String editarTransaccion(@ModelAttribute TransaccionesModel transaccion) {
        transaccionesServices.update(transaccion);
        return "redirect:/transacciones";
    }


}
