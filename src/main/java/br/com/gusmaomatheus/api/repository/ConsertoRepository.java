package br.com.gusmaomatheus.api.repository;

import br.com.gusmaomatheus.api.model.entity.Conserto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsertoRepository extends JpaRepository<Conserto, Long> {
    List<Conserto> findAllByAtivoTrue();
}