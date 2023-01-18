package com.galeria.service;

import com.galeria.dto.requestDto.AutorRequestDto;
import com.galeria.dto.responseDto.AutorResponseDto;
import com.galeria.entity.Autor;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AutorService {

    public Autor buscarAutorId(Integer id);

    ResponseEntity<List<Autor>> listarTodosLosAutores();

    ResponseEntity<List<AutorResponseDto>> listarTodosLosAutoresDto();

    ResponseEntity<String> guardarAutor(AutorRequestDto autorRequestDto);

    ResponseEntity<Autor> buscarAutorPorId(Integer id);

    ResponseEntity<String> bajaAutor(Integer id);

    ResponseEntity<String> modificarAutor(Integer id, AutorRequestDto autorRequestDto);

}
