package com.karyawan.aeon.repository;

import com.karyawan.aeon.models.KaryawanTraining;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KaryawanTrainingRepo extends JpaRepository<KaryawanTraining, Long> {
}
