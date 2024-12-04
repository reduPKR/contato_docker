package br.com.contato.service;

import br.com.contato.model.ContatoModel;
import br.com.contato.repository.ContatoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ContatoServiceTest {
    @InjectMocks
    private ContatoService service;
    @Mock
    private ContatoRepository repository;

    private ContatoModel contato;

    @BeforeEach
    public void setup() {
        contato = new ContatoModel("Rafael", "123456789");
    }

    @Test
    void deve_retornar_o_contato_por_id(){
        Optional<ContatoModel> optional = Optional.of(new ContatoModel(contato.getNome(), contato.getNumero()));
        when(repository.findById(1L)).thenReturn(optional);

        ContatoModel teste = service.buscar(1L);

        assertEquals(contato.getNome(), teste.getNome());
        assertEquals(contato.getNumero(), teste.getNumero());
        verify(repository).findById(1L);
        verifyNoMoreInteractions(repository);
    }
}