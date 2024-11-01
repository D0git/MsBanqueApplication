package com.MsBanqueApplication.MsBanqueApplication.repository;

import com.MsBanqueApplication.MsBanqueApplication.entity.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends JpaRepository<Compte,Long> {
}
