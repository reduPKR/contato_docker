package br.com.contato.mapper;

import br.com.contato.dto.ContatoRequest;
import br.com.contato.dto.ContatoResponse;
import br.com.contato.model.ContatoModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContatoMapper {
    ContatoMapper INSTANCE = Mappers.getMapper(ContatoMapper.class);

    ContatoModel requestToModel(ContatoRequest request);

    ContatoResponse modelToResponse(ContatoModel model);
}
