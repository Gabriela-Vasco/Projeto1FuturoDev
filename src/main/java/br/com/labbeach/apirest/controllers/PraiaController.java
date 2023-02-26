package br.com.labbeach.apirest.controllers;

import br.com.labbeach.apirest.models.Praia;
import br.com.labbeach.apirest.services.PraiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/praias")
public class PraiaController {
    @Autowired
    private PraiaService praiaService;

    @GetMapping
    public ResponseEntity<List<Praia>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(praiaService.findAll());
    }

    @GetMapping("/{buscaporstatus}")
    public ResponseEntity<List<Praia>> findByStatus(@PathVariable String statusPraia){
        return ResponseEntity.status(HttpStatus.OK).body(praiaService.findByStatus(statusPraia));
    }

    @GetMapping("/{buscaporacessibilidade")
    public ResponseEntity<List<Praia>> findByAcessibilidade(@PathVariable Boolean acessibilidade){
        return ResponseEntity.status(HttpStatus.OK).body(praiaService.findByAcessibilidade(acessibilidade));
    }

    @GetMapping("/{buscaporpopulacao}")
    public ResponseEntity<List<Praia>> findByBairroPop(@PathVariable Integer populacao){
        return ResponseEntity.status(HttpStatus.OK).body(praiaService.findByBairroPop(populacao));
    }

    @PostMapping
    public Long save(
            @RequestParam("nomePraia") String nomePraia,
            @RequestParam("acessibilidade") Boolean acessibilidade,
            @RequestParam("status") String status,
            @RequestParam("bairroId") Long bairroId
    ){
        return ResponseEntity.status(HttpStatus.CREATED).body(praiaService.save(nomePraia, acessibilidade, status, bairroId)).getBody();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Praia> update(@RequestBody Praia praia){
        return ResponseEntity.status(HttpStatus.OK).body(praiaService.update(praia));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteByIdPraia(@PathVariable Long id){
        praiaService.deleteByIdPraia(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
