/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo3.Reto3.Services;

import Ciclo3.Reto3.Model.ModelMessage;
import Ciclo3.Reto3.Repository.RepositoryMessage;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MaicolMoreno
 */
@Service
public class ServicesMessage {
      @Autowired
    private RepositoryMessage metodosCrud;

    public List<ModelMessage> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<ModelMessage> getMessage(int messageId) {
        return metodosCrud.getMessage(messageId);
    }

    public ModelMessage save(ModelMessage message){
        if(message.getIdMessage()==null){
            return metodosCrud.save(message);
        }else{
            Optional<ModelMessage> e= metodosCrud.getMessage(message.getIdMessage());
            if(e.isEmpty()){
                return metodosCrud.save(message);
            }else{
                return message;
            }
        }
    }

    public ModelMessage update(ModelMessage message){
        if(message.getIdMessage()!=null){
            Optional<ModelMessage> e= metodosCrud.getMessage(message.getIdMessage());
            if(!e.isEmpty()){
                if(message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
            metodosCrud.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
