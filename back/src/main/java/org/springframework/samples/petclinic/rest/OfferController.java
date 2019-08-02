package com.spring.repaso.repaso.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.repaso.repaso.models.Alumno;
import com.spring.repaso.repaso.services.AlumnoInterface;

@RestController
@RequestMapping("/")
public class AlumnoController {
	
	@Autowired
	private AlumnoInterface srv;

	@GetMapping("alumnos")
	public List<Alumno> getProfesores(){
		return srv.getAlumnos();
	}
	
//	@GetMapping("alumnos/{id}")
//	public Alumno getAlumnoById(@PathVariable("id") Integer id) {
//		return srv.getAlumnoById(id);
//	}
	
	@GetMapping("alumnos/{id}")
	public ResponseEntity<Alumno> getAlumnoById(@PathVariable("id") Integer id) {
		Alumno alumno = new Alumno();
		alumno = srv.getAlumnoById(id);
		if(alumno != null) {
			return ResponseEntity.status(HttpStatus.OK).body(alumno);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}	
	}
	
//	@PostMapping("alumnos-add")
//	public Alumno addAlumno(@RequestBody Alumno alumno) {
//		if(alumno != null) {
//			return srv.addAlumno(alumno);
//		}
//		return null;
//	}

	@PostMapping("alumnos-add")
	public ResponseEntity<Alumno>addAlumno(@RequestBody Alumno alumno) {
		if (alumno != null) {
			if(Integer.valueOf(alumno.getId()) != 0) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
			} else {
				return ResponseEntity.status(HttpStatus.OK).body(this.srv.addAlumno(alumno));
			}
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
	
	@PutMapping("alumnos-update/{id}")
	public ResponseEntity<Alumno>updateAlumno(@PathVariable Integer id, @RequestBody Alumno alumno) {
		Alumno alumnoFind = srv.getAlumnoById(id);
		if (alumnoFind != null) {
			alumno.setId(id);
			return ResponseEntity.status(HttpStatus.OK).body(this.srv.addAlumno(alumno));
		} else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
		}	
	}
	
	@DeleteMapping("alumnos-delete/{id}")
	public ResponseEntity<Alumno> borrarPorId(@PathVariable Integer id) {	
		System.out.print(id);
		Alumno alumno = srv.getAlumnoById(id);
		if (alumno != null) {
			this.srv.deleteAlumnoById(id);
			return ResponseEntity.status(HttpStatus.OK).body(alumno);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
}
