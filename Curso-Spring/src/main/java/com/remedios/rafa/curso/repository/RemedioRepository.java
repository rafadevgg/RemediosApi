package com.remedios.rafa.curso.repository;
import com.remedios.rafa.curso.model.RemedioModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RemedioRepository extends JpaRepository<RemedioModel, Long> {
}
