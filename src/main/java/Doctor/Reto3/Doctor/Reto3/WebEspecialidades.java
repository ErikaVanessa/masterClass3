/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Doctor.Reto3.Doctor.Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author erika
 */
@RestController
@RequestMapping("/api/Specialty")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class WebEspecialidades {
    @Autowired
    private ServiciosEspecialidades servicio;
    @GetMapping("/all")
    public List<Especialidades> getEspecialidades(){
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Especialidades> getEspecialidades(@PathVariable("id") int EspecialidadesId) {
        return servicio.getEspecialidades(EspecialidadesId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Especialidades save(@RequestBody Especialidades especialidades) {
        return servicio.save(especialidades);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Especialidades update(@RequestBody Especialidades especialidades) {
        return servicio.update(especialidades);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int EspecialidadesId) {
        return servicio.deleteespecialidades(EspecialidadesId);
    }
    
}