package com.karyawan.aeon.repository;

import com.karyawan.aeon.models.Karyawan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface KaryawanRepo extends JpaRepository<Karyawan, Long> {

}
