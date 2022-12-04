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

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE rekening SET deleted=true WHERE id=?")
@Where(clause = "deleted_at = false")
@Table(name = "rekening")
public class Rekening implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "jenis")
    private String jenis;

    @Column(name = "nama")
    private String nama;

    @Column(name = "nomor")
    private Long Nomor;

    @ManyToOne(targetEntity = Karyawan.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "karyawan_id")
    private Karyawan karyawan;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private boolean deleted = Boolean.FALSE;

}
