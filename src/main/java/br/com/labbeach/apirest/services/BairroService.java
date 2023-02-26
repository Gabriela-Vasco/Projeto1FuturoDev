package br.com.labbeach.apirest.services;

import br.com.labbeach.apirest.models.Bairro;
import br.com.labbeach.apirest.models.Praia;
import br.com.labbeach.apirest.repositories.BairroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BairroService {
    @Autowired
    private BairroRepository bairroRepository;

    public List<Bairro> findAll(){
        return bairroRepository.findAll();
    }


    public void deleteByIdBairro(Long id){
            bairroRepository.deleteByIdBairro(id);
    }
    
    public Bairro save(Bairro bairro){
        return bairroRepository.save(bairro);
    }

    public Bairro findById(Long id){
        Optional<Bairro> bairro = bairroRepository.findById(id);
        return (bairro.isPresent() ? bairro.get() : null);
    }
}
