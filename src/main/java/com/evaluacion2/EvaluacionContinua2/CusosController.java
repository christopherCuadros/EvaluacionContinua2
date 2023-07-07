package com.evaluacion2.EvaluacionContinua2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String createCurso(@RequestParam String nombre,@RequestParam int credito){
        try {
            Cursos cur = new Cursos();
            cur.setNombre(nombre);
            cur.setCredito(credito);

            cursorepository.save(cur);
            String cursoCreado=String.valueOf("CODIGO: "+cur.getId()+"\nNOMBRE: "+ cur.getNombre()+"\nCREDITO: "+cur.getCredito());

            return "curso creado con exito\n"+cursoCreado;
        } catch (Exception e) {
            return "No se pudo crear el curso por porblemas internos";
        }
    }


    // ELIMINAR

    @DeleteMapping(path = "/eliminar")
    public String deleteCurso(@RequestParam Integer id){
        if(!cursorepository.existsById(id)){
            return "El curso con codigo: "+ Integer.toString(id)+"No existe";
        }
        Cursos cur = new Cursos();
        cur.setId(id);
        cursorepository.delete(cur);
        return "Cursos con codigo "+Integer.toString(id)+ " eliminado";
        
    }
    
}
