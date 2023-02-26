package br.com.labbeach.apirest.controllers;

import br.com.labbeach.apirest.models.Bairro;
import br.com.labbeach.apirest.models.Praia;
import br.com.labbeach.apirest.services.BairroService;
import br.com.labbeach.apirest.services.PraiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/v1/bairros")
public class BairroController {
    @Autowired
    private BairroService bairroService;

    @GetMapping
    public ResponseEntity<List<Bairro>> findAll(){
        List<Bairro> bairros = bairroService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(bairroService.findAll());
    }

    @PostMapping
    public ResponseEntity<Bairro> create(@RequestBody Bairro bairro){
        return ResponseEntity.status(HttpStatus.CREATED).body(bairroService.save(bairro));
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<?> deleteByIdBairro(@PathVariable Long id){
        bairroService.deleteByIdBairro(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
