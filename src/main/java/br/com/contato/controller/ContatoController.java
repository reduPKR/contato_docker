package br.com.contato.controller;

import br.com.contato.dto.ContatoRequest;
import br.com.contato.dto.ContatoResponse;
import br.com.contato.mapper.ContatoMapper;
import br.com.contato.model.ContatoModel;
import br.com.contato.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contato")
public class ContatoController {
    private final ContatoService service;

    @Autowired
    public ContatoController(ContatoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ContatoResponse> save(@Validated @RequestBody ContatoRequest request){
        ContatoModel model = ContatoMapper.INSTANCE.requestToModel(request);

        service.salvar(model);
        ContatoResponse response = ContatoMapper.INSTANCE.modelToResponse(model);

        if (response.getId() != 0){
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<ContatoResponse> get(@PathVariable Long id){

        ContatoModel model = service.buscar(id);

        if (model != null){
            ContatoResponse response = ContatoMapper.INSTANCE.modelToResponse(model);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
