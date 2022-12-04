package com.karyawan.aeon.controller;


import com.karyawan.aeon.models.Karyawan;
import com.karyawan.aeon.repository.KaryawanDetailRepo;
import com.karyawan.aeon.repository.KaryawanRepo;
import com.karyawan.aeon.services.KaryawanDetailServiceInter;
import com.karyawan.aeon.services.KaryawanServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/karyawan")
public class karyawanController {

    @Autowired
    private KaryawanServiceInter karyawanServiceInter;
   @Autowired
   private KaryawanDetailServiceInter karyawanDetailServiceInter;

    @Autowired
    private KaryawanRepo karyawanRepo;

    @Autowired
    private KaryawanDetailRepo karyawanDetailRepo;

    @GetMapping("")
    public Map findAll(){
        return karyawanServiceInter.findAlls();
    }


}
