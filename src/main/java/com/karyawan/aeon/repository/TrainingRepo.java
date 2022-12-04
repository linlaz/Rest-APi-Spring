package com.karyawan.aeon.repository;

import com.karyawan.aeon.models.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepo extends JpaRepository<Training, Long> {
}
