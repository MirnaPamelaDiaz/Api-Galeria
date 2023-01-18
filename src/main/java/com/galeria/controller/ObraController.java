package com.galeria.controller;

import com.galeria.dto.requestDto.ObraRequestDto;
import com.galeria.dto.responseDto.ObraReponseDto;
import com.galeria.entity.Obra;
import com.galeria.service.impl.ObraServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/obras")
@RestController
public class ObraController {
    @Autowired
    ObraServiceImpl obraService;

    @GetMapping("/")
    ResponseEntity<List<ObraReponseDto>> listarObrasDto() {
        return obraService.listarTodasLasObrasDto();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Obra> buscarObraId(@PathVariable("id") Integer id) {
        return obraService.buscarObraPorId(id);
    }

    @PostMapping
    public ResponseEntity<String> guardarObra(@RequestBody ObraRequestDto obraRequestDto) {
        return obraService.guardarObra(obraRequestDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarObra(@PathVariable Integer id) {
        return obraService.bajaObra(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> modificarObra(@PathVariable Integer id, @RequestBody ObraRequestDto obraRequestDto) {
        return obraService.modificarObra(id, obraRequestDto);
    }
}
