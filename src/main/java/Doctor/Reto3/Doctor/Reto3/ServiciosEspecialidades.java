/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Doctor.Reto3.Doctor.Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author erika
 */
@Service
public class ServiciosEspecialidades {
   @Autowired
    private RepositorioEspecialidades metodosCrud;

    public List<Especialidades> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Especialidades> getEspecialidades(int EspecialidadesId) {
        return metodosCrud.getEspecialidades(EspecialidadesId);
    }

    public Especialidades save(Especialidades especialidades) {
        if (especialidades.getId()== null) {
            return metodosCrud.save(especialidades);
        } else {
            Optional<Especialidades> especialidad = metodosCrud.getEspecialidades(especialidades.getId());
            if (especialidad.isEmpty()) {
                return metodosCrud.save(especialidades);
            } else {
                return especialidades;
            }
        }
    }

    public Especialidades update(Especialidades especialidades){
        if(especialidades.getId()!=null){
            Optional<Especialidades>g=metodosCrud.getEspecialidades(especialidades.getId());
            if(!g.isEmpty()){
                if(especialidades.getDescription()!=null){
                    g.get().setDescription(especialidades.getDescription());
                }
                if(especialidades.getName()!=null){
                    g.get().setName(especialidades.getName());
                }
                return metodosCrud.save(g.get());
            }
        }
        return especialidades;
    }
    public boolean deleteespecialidades(int EspecialidadesId){
        Boolean d=getEspecialidades(EspecialidadesId).map(especialidades -> {
            metodosCrud.delete(especialidades);
            return true;
        }).orElse(false);
        return d;
    }
    
}