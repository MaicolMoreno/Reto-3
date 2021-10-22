/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo3.Reto3.Services;

import Ciclo3.Reto3.Model.ModelCabin;
import Ciclo3.Reto3.Repository.RepositoryCabin;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MaicolMoreno
 */

@Service
public class ServicesCabin {
     @Autowired
    private RepositoryCabin metodosCrud;

    public List<ModelCabin> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<ModelCabin> getCabin(int cabinId) {
        return metodosCrud.getCabin(cabinId);
    }

    public ModelCabin save(ModelCabin cabin){
        if(cabin.getId()==null){
            return metodosCrud.save(cabin);
        }else{
            Optional<ModelCabin> e=metodosCrud.getCabin(cabin.getId());
            if(e.isEmpty()){
                return metodosCrud.save(cabin);
            }else{
                return cabin;
            }
        }
    }

    public ModelCabin update(ModelCabin cabin){
        if(cabin.getId()!=null){
            Optional<ModelCabin> e=metodosCrud.getCabin(cabin.getId());
            if(!e.isEmpty()){
                
                if(cabin.getBrand()!=null){
                    e.get().setBrand(cabin.getBrand());
                }
                if(cabin.getRooms()!=null){
                    e.get().setRooms(cabin.getRooms());
                }    
                if(cabin.getName()!=null){
                    e.get().setName(cabin.getName());                }
                            
                if(cabin.getDescription()!=null){
                    e.get().setDescription(cabin.getDescription());
                }
                if(cabin.getCategory()!=null){
                    e.get().setCategory(cabin.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return cabin;
            }
        }else{
            return cabin;
        }
    }


    public boolean deleteCabin(int cabinId) {
        Boolean aBoolean = getCabin(cabinId).map(cabin -> {
            metodosCrud.delete(cabin);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
