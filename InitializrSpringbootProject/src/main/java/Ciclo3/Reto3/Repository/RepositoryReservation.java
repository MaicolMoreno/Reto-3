/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo3.Reto3.Repository;

import Ciclo3.Reto3.Interface.InterfaceReservation;
import Ciclo3.Reto3.Model.ModelReservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MaicolMoreno
 */
@Repository
public class RepositoryReservation {
     @Autowired
    private InterfaceReservation crud4;

    public List<ModelReservation> getAll(){
        return (List<ModelReservation>) crud4.findAll();
    }
    public Optional<ModelReservation> getReservation(int id){
        return crud4.findById(id);
    }
    public ModelReservation save(ModelReservation reservation){
        return crud4.save(reservation);
    }
    public void delete(ModelReservation reservation){
        crud4.delete(reservation);
    }
}
