package br.com.contato.service;

import br.com.contato.model.ContatoModel;
import br.com.contato.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ContatoService {
    private final ContatoRepository repository;

    @Autowired
    public ContatoService(ContatoRepository repository) {
        this.repository = repository;
    }

    public void salvar(ContatoModel model){
        repository.save(model);
    }

    @Cacheable(value = "contatos", key = "#id")
    public ContatoModel buscar(Long id)  {
        return repository.findById(id).orElse(null);
    }
}
