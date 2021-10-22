/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo3.Reto3.Services;

import Ciclo3.Reto3.Model.ModelCategory;
import Ciclo3.Reto3.Repository.RepositoryCategory;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MaicolMoreno
 */
@Service
public class ServicesCategory {
     @Autowired
    private RepositoryCategory metodosCrud;

    public List<ModelCategory> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<ModelCategory> getCategoria(int CategoriaId) {
        return metodosCrud.getCategoria(CategoriaId);
    }

    public ModelCategory save(ModelCategory categoria) {
        if (categoria.getId()== null) {
            return metodosCrud.save(categoria);
        } else {
            Optional<ModelCategory> categoria1 = metodosCrud.getCategoria(categoria.getId());
            if (categoria1.isEmpty()) {
                return metodosCrud.save(categoria);
            } else {
                return categoria;
            }
        }
    }

    public ModelCategory update(ModelCategory categoria){
        if(categoria.getId()!=null){
            Optional<ModelCategory>g=metodosCrud.getCategoria(categoria.getId());
            if(!g.isEmpty()){
                if(categoria.getDescription()!=null){
                    g.get().setDescription(categoria.getDescription());
                }
                if(categoria.getName()!=null){
                    g.get().setName(categoria.getName());
                }
                return metodosCrud.save(g.get());
            }
        }
        return categoria;
    }
    public boolean deletecategoria(int categoriaId){
        Boolean d=getCategoria(categoriaId).map(categoria -> {
            metodosCrud.delete(categoria);
            return true;
        }).orElse(false);
        return d;
    }
    
}
