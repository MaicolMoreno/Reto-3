/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo3.Reto3.Services;

import Ciclo3.Reto3.Model.ModelClient;
import Ciclo3.Reto3.Repository.RepositoryClient;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MaicolMoreno
 */

@Service
public class ServicesClient {
     @Autowired
     private RepositoryClient metodosCrud;
     
     public List<ModelClient> getAll(){
        return metodosCrud.getAll();
    }
     
      public Optional<ModelClient> getClient(int clientId) {
        return metodosCrud.getCliente(clientId);
    }

    public ModelClient save(ModelClient client){
        if(client.getIdClient()==null){
            return metodosCrud.save(client);
        }else{
            Optional<ModelClient> e= metodosCrud.getCliente(client.getIdClient());
            if(e.isEmpty()){
                return metodosCrud.save(client);
            }else{
                return client;
            }
        }
    }

    public ModelClient update(ModelClient client){
        if(client.getIdClient()!=null){
            Optional<ModelClient> e= metodosCrud.getCliente(client.getIdClient());
            if(!e.isEmpty()){
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            metodosCrud.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
