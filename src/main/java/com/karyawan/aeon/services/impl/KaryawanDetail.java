package com.karyawan.aeon.services.impl;

import com.karyawan.aeon.repository.KaryawanDetailRepo;
import com.karyawan.aeon.repository.KaryawanRepo;
import com.karyawan.aeon.services.KaryawanDetailServiceInter;
import com.karyawan.aeon.services.KaryawanServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class KaryawanDetail implements KaryawanDetailServiceInter {
    @Autowired
    private KaryawanDetailRepo karyawanDetailRepo;
    @Override
    public Map findAlls() {
        Map map = new HashMap<>();
        try{
            map.put("data", karyawanDetailRepo.findAll());
            return map;
        }catch (Exception e){
            map.put("status","gagal");
        }
        return map;
    }
}
