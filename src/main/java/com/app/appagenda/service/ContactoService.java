package com.app.appagenda.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.appagenda.entity.Contacto;
import com.app.appagenda.entity.Correo;
import com.app.appagenda.entity.Direccion;
import com.app.appagenda.entity.Telefono;
import com.app.appagenda.repository.ContactoRepository;
import com.app.appagenda.repository.CorreoRepository;
import com.app.appagenda.repository.DireccionRepository;
import com.app.appagenda.repository.TelefonoRepository;

@RestController
@RequestMapping("/contacto")
@CrossOrigin
public class ContactoService {

	@Autowired
	CorreoRepository correoRepository;
	
	@Autowired
	TelefonoRepository telefonoRepository;
	
	@Autowired
	DireccionRepository direccionRepository;
	
	@Autowired
	ContactoRepository contactoRepository;
	
	@GetMapping(path = "/buscar")
	public List<Contacto> getAllContacto(){
		return contactoRepository.findAll();
	}
	
	@PostMapping(path = "/guardar")
	public Contacto saveContacto(@RequestBody Contacto contacto) {
		
		List<Correo> correos = contacto.getCorreoList();
		List<Direccion> direcciones = contacto.getDireccionList();
		List<Telefono> telefonos = contacto.getTelefonoList();
		
		contacto.setCorreoList(null);
		contacto.setDireccionList(null);
		contacto.setTelefonoList(null);
		
		contacto = contactoRepository.save(contacto);
		
		contacto.setCorreoList(new LinkedList<>());
		contacto.setDireccionList(new LinkedList<>());
		contacto.setTelefonoList(new LinkedList<>());
		
		if(correos!=null) {
			for(Correo c:correos) {
				c.setContactoIdcontacto(contacto.getIdcontacto());
				correoRepository.save(c);
				contacto.getCorreoList().add(c);
			}
		}
		
		if(direcciones!=null) {
			for(Direccion d:direcciones) {
				d.setContactoIdcontacto(contacto.getIdcontacto());
				direccionRepository.save(d);
				contacto.getDireccionList().add(d);
			}
		}
		
		if(telefonos!=null) {
			for(Telefono t:telefonos) {
				t.setContactoIdcontacto(contacto.getIdcontacto());
				telefonoRepository.save(t);
				contacto.getTelefonoList().add(t);
			}
		}
				
		//here goes an optional code
		
		return contacto;
	}
	
	@DeleteMapping(path = "/eliminar/{idcontacto}")
	public void deleteContacto(@PathVariable("idcontacto") Integer idcontacto) {
	
	Optional<Contacto> contacto;
	contacto = contactoRepository.findById(idcontacto);
	if(contacto.isPresent()) {
		Contacto borrar = contacto.get();
		
		for(Telefono t:borrar.getTelefonoList()) {
			telefonoRepository.delete(t);
			}
		
		for(Direccion d:borrar.getDireccionList()) {
			direccionRepository.delete(d);
	}
		for(Correo c:borrar.getCorreoList()) {
			correoRepository.delete(c);
		}
		
		contactoRepository.delete(contacto.get());
		}
	}
	
	@GetMapping(path = "/buscar/correo/{correo}")
	public List<Contacto> findByCorreo(@PathVariable("correo") String correo ) {
		return contactoRepository.findByUsuarioCorreo(correo);
	}
	
}























