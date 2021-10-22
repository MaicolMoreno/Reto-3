/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo3.Reto3.Repository;

import Ciclo3.Reto3.Interface.InterfaceCategory;
import Ciclo3.Reto3.Model.ModelCategory;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MaicolMoreno
 */
@Repository
public class RepositoryCategory {
     @Autowired
    private InterfaceCategory crud;
    public List<ModelCategory> getAll(){
        return (List<ModelCategory>) crud.findAll();
    }
    public Optional<ModelCategory> getCategoria(int id){
        return crud.findById(id);
    }

    public ModelCategory save(ModelCategory Categoria){
        return crud.save(Categoria);
    }
    public void delete(ModelCategory Categoria){
       crud.delete(Categoria);
    }
}
