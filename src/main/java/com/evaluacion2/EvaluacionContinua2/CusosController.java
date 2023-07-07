package com.evaluacion2.EvaluacionContinua2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/curso")
public class CusosController {

    @Autowired
    private CursosRepository cursorepository;


    // LISTAR
    @GetMapping(path = "/listar")
    public Iterable<Cursos> getCursos(){
        return cursorepository.findAll();
    }

    // CREAR

    @PostMapping(path = "/nuevo")
    public String createCurso(@RequestBody Cursos curso){
        try {
            cursorepository.save(curso);
            String cursoCreado=String.valueOf("CODIGO: "+curso.getId()+"\nNOMBRE: "+ curso.getNombre()+"\nCREDITO: "+curso.getCredito());

            return "curso creado con exito\n"+cursoCreado;
        } catch (Exception e) {
            return "No se pudo crear el curso por porblemas internos";
        }
    }


    // ELIMINAR

    @DeleteMapping(path = "/eliminar/{id}")
    public String deleteCurso(@PathVariable("id") Integer id){
        if(!cursorepository.existsById(id)){
            return "El curso con codigo: "+ Integer.toString(id)+"No existe";
        }
        cursorepository.deleteById(id);
        return "Cursos con codigo "+Integer.toString(id)+ " eliminado";
        
    }
    
}
