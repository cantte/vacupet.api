package com.tic.vacupet.vaccines.infrastructure;

import com.tic.vacupet.vaccines.domain.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Long> {

}
