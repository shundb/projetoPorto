package com.example.lineporto.domain.repositories;

import com.example.lineporto.domain.entities.Navio.Navio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NavioRepository extends JpaRepository<Navio, Long> {
}
