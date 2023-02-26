package br.com.labbeach.apirest.repositories;

import br.com.labbeach.apirest.models.Bairro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BairroRepository extends JpaRepository<Bairro, Long> {

    List<Bairro> findAll();

    void deleteByIdBairro(Long id);

}
