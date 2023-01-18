package com.galeria.controller;


import com.galeria.dto.requestDto.AutorRequestDto;
import com.galeria.dto.responseDto.AutorResponseDto;
import com.galeria.entity.Autor;
import com.galeria.service.impl.AutorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    @Autowired
    private AutorServiceImpl autorService;

    @GetMapping("/")
    ResponseEntity<List<AutorResponseDto>> listarAutoresDto() {
        return autorService.listarTodosLosAutoresDto();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> buscarAutorId(@PathVariable("id") Integer id) {
        return autorService.buscarAutorPorId(id);
    }

    @PostMapping
    public ResponseEntity<String> guardarAutor(@RequestBody AutorRequestDto autorRequestDto) {
        return autorService.guardarAutor(autorRequestDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarAutor(@PathVariable Integer id) {
        return autorService.bajaAutor(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> modificarAutor(@PathVariable Integer id, @RequestBody AutorRequestDto automorRequestDto) {
        return autorService.modificarAutor(id, automorRequestDto);
    }

}
