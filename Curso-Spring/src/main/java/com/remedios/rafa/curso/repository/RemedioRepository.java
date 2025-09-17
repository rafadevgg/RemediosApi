package com.remedios.rafa.curso.repository;
import com.remedios.rafa.curso.model.RemedioModel;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RemedioRepository extends JpaRepository<RemedioModel, Long> {

    List<RemedioModel> findAllByAtivoTrue();
}
