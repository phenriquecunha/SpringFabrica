package br.com.spring.fabrica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.spring.fabrica.models.Fabrica;

@Repository
public interface FabricaRepository extends JpaRepository<Fabrica, Long>{}
