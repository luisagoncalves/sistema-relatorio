package br.dev.luisagoncalves.sisrelatorio.repositories;

import org.springframework.data.repository.CrudRepository;

import br.dev.luisagoncalves.sisrelatorio.models.Relatorio;

public interface RelatorioRepository extends CrudRepository<Relatorio, Long>{
    
}
