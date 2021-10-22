/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo3.Reto3.Repository;

import Ciclo3.Reto3.Interface.InterfaceCabin;
import Ciclo3.Reto3.Model.ModelCabin;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MaicolMoreno
 */

@Repository
public class RepositoryCabin {
     
    @Autowired
    private InterfaceCabin crud;

    public List<ModelCabin> getAll(){
        return (List<ModelCabin>) crud.findAll();
    }

    public Optional<ModelCabin> getCabin(int id){
        return crud.findById(id);
    }

    public ModelCabin save(ModelCabin cabin){
        return crud.save(cabin);
    }
    public void delete(ModelCabin cabin){
        crud.delete(cabin);
}
}
