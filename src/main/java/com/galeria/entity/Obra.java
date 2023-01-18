package com.galeria.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "obra")
@SQLDelete(sql = "UPDATE obra SET alta=false WHERE id_obra = ?")
@Where(clause = "alta = true")
public class Obra {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_obra")
  private Integer id;

  private String titulo;

  private Integer anio;

 @ManyToOne
 @JoinColumn(name = "autor_id_autor")
  private Autor autor;

  private String descripcion;

  private String foto;

  @Enumerated(EnumType.STRING)
  private Tipo tipo;

  @Column(nullable = false)
  private Boolean alta = true;
}
