package com.teste4.demo.repository;

import com.teste4.demo.model.Operadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperadoraRepository extends JpaRepository<Operadora, Long> {

    List<Operadora> findByNomeContainingIgnoreCase(String nome);
}
