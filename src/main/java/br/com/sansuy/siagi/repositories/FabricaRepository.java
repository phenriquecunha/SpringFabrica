package br.com.sansuy.siagi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sansuy.siagi.models.Fabrica;

@Repository
public interface FabricaRepository extends JpaRepository<Fabrica, Long>{}
