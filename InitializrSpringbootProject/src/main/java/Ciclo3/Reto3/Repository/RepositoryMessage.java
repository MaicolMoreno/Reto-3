/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo3.Reto3.Repository;

import Ciclo3.Reto3.Interface.InterfaceMessage;
import Ciclo3.Reto3.Model.ModelMessage;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MaicolMoreno
 */
@Repository
public class RepositoryMessage {
      @Autowired
    private InterfaceMessage crud3;
    public List<ModelMessage> getAll(){
        return (List<ModelMessage>) crud3.findAll();
    }
    public Optional<ModelMessage> getMessage(int id){
        return crud3.findById(id);
    }

    public ModelMessage save(ModelMessage message){
        return crud3.save(message);
    }
    public void delete(ModelMessage message){
        crud3.delete(message);
    }
}
