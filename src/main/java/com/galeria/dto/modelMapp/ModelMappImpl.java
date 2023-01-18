package com.galeria.dto.modelMapp;

import com.galeria.dto.requestDto.AutorRequestDto;
import com.galeria.dto.requestDto.ObraRequestDto;
import com.galeria.dto.responseDto.AutorResponseDto;
import com.galeria.dto.responseDto.ObraReponseDto;
import com.galeria.entity.Autor;
import com.galeria.entity.Obra;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ModelMappImpl implements ModelMapp {
    ModelMapper mm = new ModelMapper();

    @Override
    public AutorResponseDto autorMapResponseDto(Autor autor) {
        return mm.map(autor, AutorResponseDto.class);
    }

    @Override
    public List<AutorResponseDto> autorMapResponseDtos(List<Autor> listAutor) {
        return listAutor.stream().map(this::autorMapResponseDto).collect(Collectors.toList());
    }

    @Override
    public Autor requestDtoMapAutor(AutorRequestDto autorRequestDto) {
        return mm.map(autorRequestDto, Autor.class);
    }

    @Override
    public ObraReponseDto obraMapResponseDto(Obra obra) {
        return mm.map(obra, ObraReponseDto.class);
    }

    @Override
    public List<ObraReponseDto> obraMapResponseDtos(List<Obra> listObra) {
        return listObra.stream().map(this::obraMapResponseDto).collect(Collectors.toList());
    }

    @Override
    public Obra requestDtoMapObra(ObraRequestDto obraRequestDto) {
        return mm.map(obraRequestDto, Obra.class);
    }

    @Override
    public ObraRequestDto obraMapRequestDto(Obra obra) {
        return mm.map(obra,ObraRequestDto.class);
    }

}
