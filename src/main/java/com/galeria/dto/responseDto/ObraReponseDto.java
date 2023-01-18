package com.galeria.dto.responseDto;

import com.galeria.entity.Tipo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ObraReponseDto {
    private String titulo;

    private Integer anio;

    private String foto;

    private Tipo tipo;

}
