package com.reto2.web.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.reto2.web.Model.Gadget;
import com.reto2.web.Service.GadgetService;

@RestController
@RequestMapping("/api/gadget")
public class GadgetController {
    @Autowired
    private GadgetService gadgetService;

    @PostMapping("/new")
    //@ResponseStatus(HttpStatus.CREATED)
    public Gadget save(@RequestBody Gadget gadget){
        return gadgetService.save(gadget);
    }

    @GetMapping("/all")
    public List<Gadget> getAll(){
        return gadgetService.getAll();
    }

    @GetMapping("/id/{id}")
    public Gadget getGadget(@PathVariable int id){
        return gadgetService.getGadget(id);
    }

    @PutMapping("/update")
    //@ResponseStatus(HttpStatus.CREATED)
    public Gadget Update(@RequestBody Gadget gadget){
        return gadgetService.update(gadget);
    }

    @DeleteMapping("/{id}")
    //@ResponseStatus(HttpStatus.No_CONTENT)
    public void delete(@PathVariable int id){
        gadgetService.delete(id);
    }

}

