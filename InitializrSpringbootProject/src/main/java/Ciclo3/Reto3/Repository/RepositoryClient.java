/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo3.Reto3.Repository;

import Ciclo3.Reto3.Interface.InterfaceClient;
import Ciclo3.Reto3.Model.ModelClient;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MaicolMoreno
 */
@Repository
public class RepositoryClient {
     @Autowired
    private InterfaceClient crud1;

    public List<ModelClient> getAll(){
        return (List<ModelClient>) crud1.findAll();
    }
    public Optional<ModelClient> getCliente(int id){
        return crud1.findById(id);
    }

    public ModelClient save(ModelClient cliente){
        return crud1.save(cliente);
    }
    public void delete(ModelClient cliente){
        crud1.delete(cliente);
    }
}
