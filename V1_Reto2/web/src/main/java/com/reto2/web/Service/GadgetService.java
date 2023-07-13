package com.reto2.web.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reto2.web.Model.Gadget;
import com.reto2.web.Repository.GadgetRepository;

@Service
public class GadgetService {
 
    @Autowired
    private GadgetRepository gadgetRepository;

    public List<Gadget> getAll(){
        return gadgetRepository.findAll();
    }
    
    public Gadget getGadget(int id){
        Optional<Gadget> gadgetEncontrado = gadgetRepository.findById(id);
        if(gadgetEncontrado.isPresent()){
            return gadgetEncontrado.get();
        }else{
            System.out.println("No se encontro el producto con el id: " +id);
            return new Gadget();
        }
    }

    public Gadget save(Gadget gadget){
        return gadgetRepository.save(gadget);
    }

    public Gadget update(Gadget gadget){
        if(gadget.getId()!=null){
            Optional <Gadget> gadgetEncontrado = gadgetRepository.findById(gadget.getId());
            if(gadgetEncontrado.isPresent()){
                if(gadget.getBrand()!=null){
                    gadgetEncontrado.get().setBrand(gadget.getBrand());
                }
                if(gadget.getCategory()!=null){
                    gadgetEncontrado.get().setCategory(gadget.getCategory());
                }
                if(gadget.getName()!=null){
                    gadgetEncontrado.get().setName(gadget.getName());
                }
                if(gadget.getDescription()!=null){
                    gadgetEncontrado.get().setDescription(gadget.getDescription());
                }
                if(gadget.getPrice()!=null){
                    gadgetEncontrado.get().setPrice(gadget.getPrice());
                }
                if(gadget.getAvailability()!=null){
                    gadgetEncontrado.get().setAvailability(gadget.getAvailability());
                }
                if(gadget.getQuantity()!=null){
                    gadgetEncontrado.get().setQuantity(gadget.getQuantity());
                }
                if(gadget.getPhotography()!=null){
                    gadgetEncontrado.get().setPhotography(gadget.getPhotography());
                }
                return gadgetRepository.save(gadgetEncontrado.get());
            }else{
                return gadget;
            }
        }else{
            return gadget;
        }
    } 

    public boolean delete(int id){
        Boolean respuesta = gadgetRepository.findById(id).map(gadget -> {
            gadgetRepository.delete(gadget);
            return true;
        }).orElse(false);
        return respuesta;
    } 

}
