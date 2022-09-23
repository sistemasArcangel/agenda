package com.app.appagenda.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.appagenda.entity.Rol;

@Repository("rolRepository")

public interface RolRepository extends JpaRepository<Rol,Serializable>{
    @Override
    List<Rol> findAll();
}
