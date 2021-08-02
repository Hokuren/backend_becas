package com.me.becas.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.me.becas.model.entity.Programa;

public interface IProgramaDao extends JpaRepository<Programa, Long>{

}
