package com.karyawan.aeon.models;

import com.fasterxml.jackson.annotation.*;
import com.karyawan.aeon.enums.JenisKelamin;
import com.karyawan.aeon.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE user SET deleted=true WHERE id=?")
@Where(clause = "deleted_at = false")
@Table(name = "karyawan")
public class Karyawan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name",nullable = false,length = 120)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "jenis_kelamin", nullable = false)
    private JenisKelamin JK;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @OneToOne(mappedBy = "karyawan", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private KaryawanDetail karyawanDetail;

    @OneToMany(mappedBy = "karyawan", cascade = CascadeType.ALL)
    private List<Rekening> rekenings;

    @OneToMany(mappedBy = "peserta", cascade = CascadeType.ALL)
    private List<KaryawanTraining> trainings;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private boolean deleted = Boolean.FALSE;

}
