package com.app.appagenda.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.appagenda.entity.Contacto;

@Repository("contactoRepository")
public interface ContactoRepository extends JpaRepository<Contacto,Serializable>{
	
	public List<Contacto> findByUsuarioCorreo(String usuarioCorreo);
}
