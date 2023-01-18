package com.galeria.dto.modelMapp;

import com.galeria.dto.requestDto.AutorRequestDto;
import com.galeria.dto.requestDto.ObraRequestDto;
import com.galeria.dto.responseDto.AutorResponseDto;
import com.galeria.dto.responseDto.ObraReponseDto;
import com.galeria.entity.Autor;
import com.galeria.entity.Obra;

import java.util.List;

public interface ModelMapp {
    AutorResponseDto autorMapResponseDto(Autor autor);

    List<AutorResponseDto> autorMapResponseDtos(List<Autor> listAutor);

    Autor requestDtoMapAutor(AutorRequestDto autorRequestDto);


    ObraReponseDto obraMapResponseDto(Obra obra);

    List<ObraReponseDto> obraMapResponseDtos(List<Obra> listObra);

    Obra requestDtoMapObra(ObraRequestDto obraRequestDto);

    ObraRequestDto obraMapRequestDto(Obra obra);

}
