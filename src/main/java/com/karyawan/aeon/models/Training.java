package com.karyawan.aeon.models;

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
@SQLDelete(sql = "UPDATE training SET deleted=true WHERE id=?")
@Where(clause = "deleted_at = false")
@Table(name = "training")
public class Training implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama_pengajar",nullable = false)
    private String namaPengajar;

    @Column(name = "tema",nullable = false)
    private String tema;

    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL)
    private List<KaryawanTraining> trainer;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private boolean deleted = Boolean.FALSE;
}
