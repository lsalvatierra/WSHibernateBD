/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idat.edu.pe.controller;

import idat.edu.pe.data.AlumnoData;
import idat.edu.pe.entidades.Alumno;
import java.util.List;
import javax.ws.rs.core.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LuisAngel
 */
@RestController
@RequestMapping("/Alumno")
public class AlumnoController {
    
    @RequestMapping(value="/ListarAlumnos", 
            method = RequestMethod.GET, 
            produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<List<Alumno>> ListarAlumnos()
    {
            AlumnoData objAluData = new AlumnoData();
            List<Alumno> lstAlumno = objAluData.ListarAlumno();        
            return new ResponseEntity<>(lstAlumno, HttpStatus.OK);  
    }    
}
