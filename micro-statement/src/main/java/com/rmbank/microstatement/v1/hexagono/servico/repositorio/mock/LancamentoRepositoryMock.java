package com.rmbank.microstatement.v1.hexagono.servico.repositorio.mock;

import com.rmbank.microstatement.v1.hexagono.dominio.Cadastro;
import com.rmbank.microstatement.v1.hexagono.dominio.Conta;
import com.rmbank.microstatement.v1.hexagono.dominio.Lancamento;
import com.rmbank.microstatement.v1.hexagono.dominio.Usuario;
import com.rmbank.microstatement.v1.hexagono.servico.repositorio.jpa.LancamentoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

@Component
@Profile("dev")
@Slf4j
public class LancamentoRepositoryMock implements LancamentoRepository {
    @Override
    public List<Lancamento> findAll() {
        return null;
    }

    @Override
    public List<Lancamento> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Lancamento> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Lancamento> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Lancamento entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Lancamento> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Lancamento> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Lancamento> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Lancamento> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Lancamento> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Lancamento> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Lancamento> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Lancamento getOne(Long id) {
        return null;
    }

    @Override
    public Lancamento getById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Lancamento> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Lancamento> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Lancamento> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Lancamento> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Lancamento> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Lancamento> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Lancamento, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public List<Lancamento> getPorData(Long idConta, LocalDateTime inicio, LocalDateTime fim) {
        List<Lancamento> list = new ArrayList<>();
        Cadastro cadastro = new Cadastro();
        cadastro.setId(1L);
        cadastro.setNome("Jose Mock");
        cadastro.setTelefone("11912345678");
        cadastro.setEmail("jose_mock@email.com");
        cadastro.setCpfCnpj("44314196084");

        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("josemock");
        usuario.setSenha("1234");
        usuario.setCadastro(cadastro);

        Conta conta = new Conta();
        conta.setId(1L);
        conta.setUsuario(usuario);
        conta.setNumero(1234);
        conta.setAtiva(true);

        Cadastro cadastroDestinatario = new Cadastro();
        cadastroDestinatario.setId(1L);
        cadastroDestinatario.setNome("Maria Destinatario Mock");
        cadastroDestinatario.setTelefone("11987654321");
        cadastroDestinatario.setEmail("maria_mock@email.com");
        cadastroDestinatario.setCpfCnpj("68040924065");

        Usuario usuarioDestinatario = new Usuario();
        usuarioDestinatario.setId(1L);
        usuarioDestinatario.setNome("mariamock");
        usuarioDestinatario.setSenha("1234");
        usuarioDestinatario.setCadastro(cadastroDestinatario);

        Conta contaDestinatario = new Conta();
        contaDestinatario.setId(2L);
        contaDestinatario.setUsuario(usuarioDestinatario);
        contaDestinatario.setNumero(5678);
        contaDestinatario.setAtiva(true);

        Cadastro cadastroRemetente = new Cadastro();
        cadastroRemetente.setId(1L);
        cadastroRemetente.setNome("Joao Remetente Mock");
        cadastroRemetente.setTelefone("11955786532");
        cadastroRemetente.setEmail("joao_mock@email.com");
        cadastroRemetente.setCpfCnpj("75200382033");

        Usuario usuarioRemetente = new Usuario();
        usuarioRemetente.setId(1L);
        usuarioRemetente.setNome("joaomock");
        usuarioRemetente.setSenha("1234");
        usuarioRemetente.setCadastro(cadastro);

        Conta contaRemetente = new Conta();
        contaRemetente.setId(2L);
        contaRemetente.setUsuario(usuarioRemetente);
        contaRemetente.setNumero(9012);
        contaRemetente.setAtiva(true);

        for (int x = 0; x < 5; x++) {
            Lancamento lancamento = new Lancamento();
            lancamento.setId(x + 1L);
            lancamento.setConta(conta);
            lancamento.setValor(BigDecimal.valueOf(Math.random() * 1000));
            if (x % 2 == 0) {
                lancamento.setDebitoCredito("c");
                lancamento.setRemetente(contaDestinatario);
            } else {
                lancamento.setDebitoCredito("d");
                lancamento.setDestinatario(contaDestinatario);
            }
            lancamento.setDtHrLancamento(inicio.plusSeconds(10L + x));
            lancamento.setDescricao("transacao mock");
            lancamento.setUuid(UUID.randomUUID().toString());
            list.add(lancamento);
        }
        for(Lancamento lancamento : list) {
            log.info("LancamentoRepositoryMock => " + lancamento.toString());
        }
        return list;
    }
}
