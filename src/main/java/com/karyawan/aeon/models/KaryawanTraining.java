package com.karyawan.aeon.models;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@SQLDelete(sql = "UPDATE user SET deleted=true WHERE id=?")
@Where(clause = "deleted_at = false")
@Table(name = "karyawan_training")
public class KaryawanTraining implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "tanggal_training")
    private Date tanggalTraining;

    @JoinColumn(name = "training_id")
    @ManyToOne(targetEntity = Training.class, cascade = CascadeType.ALL)
    private Training trainer;

    @JoinColumn(name = "karyawan_id")
    @ManyToOne(targetEntity = Karyawan.class, cascade = CascadeType.ALL)
    private Karyawan peserta;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private boolean deleted = Boolean.FALSE;

}
