package com.evaluacion2.EvaluacionContinua2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class EstudianteController {
    

    @GetMapping(path = "/")
    public String mostrarCodigoNombre(){
        return "SM74289012  -> CHRISTOPHER JUNIOR CUADROS MATTA";
    }


    @GetMapping(path = "/idat/codigo")
    public String mostrarCodigo(){
        return "SM74289012";
    }

    @GetMapping(path = "/idat/nombre-completo")
    public String mostrarNombre(){
        return "Christopher junior cuadros matta";
    }
}
