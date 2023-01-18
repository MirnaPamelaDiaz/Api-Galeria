package com.galeria.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "autor")
@SQLDelete(sql = "UPDATE autor SET alta=false WHERE id_autor = ?")
@Where(clause = "alta = true")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_autor")
    private Integer id;

    private String nombre;

    private String apellido;

    private String nacionalidad;

    @Column(nullable = false)
    private Boolean alta = true;

    @OneToMany(mappedBy = "autor")
    private List<Obra> obraList = new ArrayList<>();
}
