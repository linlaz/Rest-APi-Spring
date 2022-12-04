package com.karyawan.aeon.repository;

import com.karyawan.aeon.models.Rekening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RekeningRepo extends JpaRepository<Rekening, Long> {
}
