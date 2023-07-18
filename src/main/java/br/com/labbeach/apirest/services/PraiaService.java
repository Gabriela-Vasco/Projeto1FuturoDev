package br.com.labbeach.apirest.services;

import br.com.labbeach.apirest.models.Bairro;
import br.com.labbeach.apirest.models.Praia;
import br.com.labbeach.apirest.repositories.PraiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PraiaService {
    @Autowired
    private PraiaRepository praiaRepository;
    private BairroService bairroService;

    public List<Praia> findAll(){
        return praiaRepository.findAll();
    }

    public List<Praia> findByStatus(String statusPraia){
        return praiaRepository.findByStatus(statusPraia);
    }

    public List<Praia> findByAcessibilidade(Boolean acessbilidade){
        return praiaRepository.findByAcessibilidade(acessbilidade);
    }

    public List<Praia> findByBairroPop(Integer populacao){
        return praiaRepository.findByBairroPop(populacao);
    }

    public Praia update(Praia praia){
        return praiaRepository.save(praia);
    }

    public void deleteByIdPraia(Long id){
        praiaRepository.deleteByIdPraia(id);
    }

    public Long save(String nomePraia,
                     Boolean acessibilidade,
                     String statusPraia,
                     Long bairroId){
        Praia praia = new Praia();
        Bairro bairro = bairroService.findById(bairroId);

        praia.setNomePraia(nomePraia);
        praia.setAcessibilidade(acessibilidade);
        praia.setStatusPraia(statusPraia);
        praia.setBairro(bairro);
        return praiaRepository.save(praia).getId();
    }
}
