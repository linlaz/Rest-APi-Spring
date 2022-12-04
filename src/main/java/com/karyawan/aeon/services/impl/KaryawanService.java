package com.karyawan.aeon.services.impl;

import com.karyawan.aeon.models.Karyawan;
import com.karyawan.aeon.repository.KaryawanRepo;
import com.karyawan.aeon.services.KaryawanServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class KaryawanService implements KaryawanServiceInter {

    @Autowired
    public KaryawanRepo karyawanRepo;

    @Override
    public Map save(Karyawan karyawan) {
        Map map = new HashMap<>();
        try {
            Karyawan saveKaryawan = karyawanRepo.save(karyawan);
            map.put("data", saveKaryawan);
            map.put("status", HttpStatus.OK);
            return map;
        }catch (Exception e){
            e.printStackTrace();
            map.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
            return map;
        }
    }

    @Override
    public Map findAlls() {
        Map map = new HashMap();
        try{
            List<Karyawan> karyawans= karyawanRepo.findAll();
            System.out.println(karyawans);
            map.put("data",karyawans);
            map.put("status",HttpStatus.OK);
            return map;
        }catch (Exception e){
            e.printStackTrace();
            map.put("status",HttpStatus.INTERNAL_SERVER_ERROR);
            return map;
        }
    }


}
