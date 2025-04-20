package br.com.gusmaomatheus.api.repository;

import br.com.gusmaomatheus.api.model.conserto.Conserto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsertoRepository extends JpaRepository<Conserto, Long> {}