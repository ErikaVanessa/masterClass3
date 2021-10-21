/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Doctor.Reto3.Doctor.Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author erika
 */
@Repository
public class RepositorioEspecialidades {
     @Autowired
    private InterfaceEspecialidades crud;
    public List<Especialidades> getAll(){
        return (List<Especialidades>) crud.findAll();
    }
    public Optional<Especialidades> getEspecialidades(int id){
        return crud.findById(id);
    }

    public Especialidades save(Especialidades Especialidad){
        return crud.save(Especialidad);
    }
    public void delete(Especialidades Especialidad){
       crud.delete(Especialidad);
    }
}