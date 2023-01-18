package com.galeria.service.impl;

import com.galeria.dto.modelMapp.ModelMapp;
import com.galeria.dto.requestDto.ObraRequestDto;
import com.galeria.dto.responseDto.ObraReponseDto;
import com.galeria.entity.Autor;
import com.galeria.entity.Obra;
import com.galeria.repository.AutorRepository;
import com.galeria.repository.ObraRepository;
import com.galeria.service.AutorService;
import com.galeria.service.ObraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ObraServiceImpl implements ObraService {
    @Autowired
    ObraRepository obraRepository;

    @Autowired
    private ModelMapp mapp;

    @Autowired
    AutorService autorService;

    @Override
    public ResponseEntity<List<Obra>> listarTodasLasObras() {
        return ResponseEntity.status(HttpStatus.OK).body(obraRepository.findAll());
    }

    @Override
    public ResponseEntity<List<ObraReponseDto>> listarTodasLasObrasDto() {
        List<Obra> obraList = obraRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(mapp.obraMapResponseDtos(obraList));
    }

    @Override
    public ResponseEntity<String> guardarObra(ObraRequestDto obraRequestDto) {
        Obra obraNueva = mapp.requestDtoMapObra(obraRequestDto);
        Autor autor = autorService.buscarAutorId(obraRequestDto.getAutor());
        obraNueva.setAutor(autor);
        obraRepository.save(obraNueva);
        return ResponseEntity.status(HttpStatus.CREATED).body("Obra creada exitosamente");
    }

    @Override
    public ResponseEntity<Obra> buscarObraPorId(Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(obraRepository.findById(id).orElseThrow());
    }

    @Override
    public ResponseEntity<String> bajaObra(Integer id) {
        obraRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Obra eliminada exitosamente");
    }

    @Override
    public ResponseEntity<String> modificarObra(Integer id, ObraRequestDto obraRequestDto) {
      // obraRepository.existsById(id);
        Obra obraModf = mapp.requestDtoMapObra(obraRequestDto);
        obraModf.setId(id);
        Autor autor = autorService.buscarAutorId(obraRequestDto.getAutor());
        obraModf.setAutor(autor);
        obraRepository.save(obraModf);
        return ResponseEntity.status(HttpStatus.OK).body("Obra modificada exitosamente");

    }

    public ObraRequestDto mapearAutor(String nombreAutor, Map<String, Object> atributoDto) {

        Obra obra = new Obra();

        if (atributoDto.containsKey("nombreAutor")) {
            Map<String, Object> nombreAtributo = (Map<String, Object>) atributoDto.get("nomreAutor");
            String nombre = (String) nombreAtributo.get("nombreAutor");
            obra.getAutor().setNombre(nombre);
        }
        return mapp.obraMapRequestDto(obra);


    }
}