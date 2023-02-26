package br.com.labbeach.apirest.repositories;

import br.com.labbeach.apirest.models.Praia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PraiaRepository extends JpaRepository<Praia, Long> {

    List<Praia> findAll();

    @Override
    Optional<Praia> findById(Long aLong);

    List<Praia> findByStatus(String statusPraia);

    List<Praia> findByAcessibilidade(Boolean acessibilidade);

    void deleteByIdPraia(Long id);

    Praia update(Praia praia);

    @Query("SELECT p FROM Praia p " +
            "LEFT JOIN Bairro b on ( p.bairro = b) " +
            "WHERE b.populacao <= :num")
    List<Praia> findByBairroPop(@Param("num") Integer populacao);
}
