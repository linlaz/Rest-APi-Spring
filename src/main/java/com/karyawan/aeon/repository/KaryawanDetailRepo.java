package com.karyawan.aeon.repository;

import com.karyawan.aeon.models.KaryawanDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KaryawanDetailRepo extends JpaRepository<KaryawanDetail,Long> {

}
