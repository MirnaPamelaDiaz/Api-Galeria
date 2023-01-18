package com.galeria.service.impl;

import com.galeria.dto.modelMapp.ModelMapp;
import com.galeria.dto.requestDto.AutorRequestDto;
import com.galeria.dto.responseDto.AutorResponseDto;
import com.galeria.entity.Autor;
import com.galeria.repository.AutorRepository;
import com.galeria.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServiceImpl implements AutorService {
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private ModelMapp mapp;

    @Override
    public Autor buscarAutorId(Integer id){
       return autorRepository.findById(id).get();
    }

    @Override
    public ResponseEntity<List<Autor>> listarTodosLosAutores() {
        return ResponseEntity.ok().body(autorRepository.findAll());
    }

    @Override
    public ResponseEntity<List<AutorResponseDto>> listarTodosLosAutoresDto() {
        List<Autor> autorList = autorRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(mapp.autorMapResponseDtos(autorList));
    }

    @Override
    public ResponseEntity<String> guardarAutor(AutorRequestDto autorRequestDto) {
        Autor autorNuevo = mapp.requestDtoMapAutor(autorRequestDto);
        autorRepository.save(autorNuevo);
        return ResponseEntity.status(HttpStatus.CREATED).body("Autor creado exitosamente");
    }

    @Override
    public ResponseEntity<Autor> buscarAutorPorId(Integer id) {

        return ResponseEntity.status(HttpStatus.OK).body(autorRepository.findById(id).orElseThrow());
    }

    @Override
    public ResponseEntity<String> bajaAutor(Integer id) {
        autorRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Autor eliminado exitosamente");
    }

    @Override
    public ResponseEntity<String> modificarAutor(Integer id, AutorRequestDto autorRequestDto) {
        Autor autorMod = autorRepository.findById(id).get();
        autorMod.setNacionalidad(autorRequestDto.getNacionalidad());
        autorMod.setApellido(autorRequestDto.getApellido());
        autorMod.setNombre(autorRequestDto.getNombre());
        autorRepository.save(autorMod);
        return ResponseEntity.status(HttpStatus.OK).body("Autor Modificado exitosamente");

    }
}
