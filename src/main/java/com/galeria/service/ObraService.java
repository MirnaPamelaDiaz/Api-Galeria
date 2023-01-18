package com.galeria.service;

import com.galeria.dto.requestDto.AutorRequestDto;
import com.galeria.dto.requestDto.ObraRequestDto;
import com.galeria.dto.responseDto.AutorResponseDto;
import com.galeria.dto.responseDto.ObraReponseDto;
import com.galeria.entity.Autor;
import com.galeria.entity.Obra;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ObraService {
    ResponseEntity<List<Obra>> listarTodasLasObras();
    ResponseEntity<List<ObraReponseDto>> listarTodasLasObrasDto();

    ResponseEntity<String> guardarObra(ObraRequestDto obraRequestDto);

    ResponseEntity<Obra> buscarObraPorId(Integer id);

    ResponseEntity<String> bajaObra(Integer id);

    ResponseEntity<String> modificarObra(Integer id, ObraRequestDto obraRequestDto);

}
