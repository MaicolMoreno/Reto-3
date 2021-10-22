/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo3.Reto3.Interface;

import Ciclo3.Reto3.Model.ModelMessage;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author MaicolMoreno
 */
public interface InterfaceMessage extends CrudRepository<ModelMessage,Integer>{
    
}
