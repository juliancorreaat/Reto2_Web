package com.reto2.web.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reto2.web.Model.User;
import com.reto2.web.Repository.UserRepository;

@Service
public class UserService {
 
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.findAll();
    }
    
    public User getUser(int id){
        Optional<User> userEncontrado = userRepository.findById(id);
        if(userEncontrado.isPresent()){
            return userEncontrado.get();
        }else{
            System.out.println("No se encontro el usuario con el id: " +id);
            return new User();
        }
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public User update(User user){
        if(user.getId()!=null){
            Optional <User> userEncontrado = userRepository.findById(user.getId());
            if(userEncontrado.isPresent()){
                if(user.getIdentification()!=null){
                    userEncontrado.get().setIdentification(user.getIdentification());
                }
                if(user.getName()!=null){
                    userEncontrado.get().setName(user.getName());
                }
                if(user.getAddress()!=null){
                    userEncontrado.get().setAddress(user.getAddress());
                }
                if(user.getCellPhone()!=null){
                    userEncontrado.get().setCellPhone(user.getCellPhone());
                }
                if(user.getEmail()!=null){
                    userEncontrado.get().setEmail(user.getEmail());
                }
                if(user.getPassword()!=null){
                    userEncontrado.get().setPassword(user.getPassword());
                }
                if(user.getZone()!=null){
                    userEncontrado.get().setZone(user.getZone());
                }
                if(user.getType()!=null){
                    userEncontrado.get().setType(user.getType());
                }
                return userRepository.save(userEncontrado.get());
            }else{
                return user;
            }
        }else{
            return user;
        }
    } 

    public boolean delete(int id){
        Boolean respuesta = userRepository.findById(id).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return respuesta;
    }

    public boolean emailExists(String email){
        Optional <User> userEncontrado = userRepository.getUserByEmail(email);
        return userEncontrado.isPresent();
    }

    public User authUser(String email, String password){
        Optional<User> userEncontrado = userRepository.getUserByEmailAndPassword(email, password);
        if(userEncontrado.isPresent()){
            return userEncontrado.get();
        }else{
            return new User();
        }
    }
    

}
