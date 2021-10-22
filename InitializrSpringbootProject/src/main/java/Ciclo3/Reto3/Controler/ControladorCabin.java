/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo3.Reto3.Controler;

import Ciclo3.Reto3.Model.ModelCabin;
import Ciclo3.Reto3.Services.ServicesCabin;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MaicolMoreno
 */
@RestController
@RequestMapping("/api/Cabin")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})


public class ControladorCabin {
     @Autowired
    private ServicesCabin servicio;
    @GetMapping("/all")
    public List<ModelCabin> getCabin(){
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<ModelCabin> getCabin(@PathVariable("id") int cabiId) {
        return servicio.getCabin(cabiId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ModelCabin save(@RequestBody ModelCabin cabin) {
        return servicio.save(cabin);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ModelCabin update(@RequestBody ModelCabin cabin) {
        return servicio.update(cabin);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int cabinId) {
        return servicio.deleteCabin(cabinId);
    } 
}
