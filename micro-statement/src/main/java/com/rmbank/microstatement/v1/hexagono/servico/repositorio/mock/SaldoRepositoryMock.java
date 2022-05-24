package com.rmbank.microstatement.v1.hexagono.servico.repositorio.mock;

import com.rmbank.microstatement.v1.hexagono.dominio.Cadastro;
import com.rmbank.microstatement.v1.hexagono.dominio.Conta;
import com.rmbank.microstatement.v1.hexagono.dominio.Saldo;
import com.rmbank.microstatement.v1.hexagono.dominio.Usuario;
import com.rmbank.microstatement.v1.hexagono.servico.repositorio.jpa.SaldoRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class SaldoRepositoryMock implements SaldoRepository {
    @Override
    public Optional<Saldo> getSaldo(Long idConta) {
        return Optional.of(new Saldo(
                1L,
                new Conta(
                        1L,
                        new Usuario(
                                1L,
                                "usuario",
                                "1234senha",
                                new Cadastro(
                                        1L,
                                        "Joao teste cadastro",
                                        "11912345678",
                                        "joao_teste@email.com",
                                        "98501737003"
                                )
                        ),
                        1234,
                        true
                ),
                BigDecimal.valueOf(1000),
                LocalDateTime.now()
        ));
    }

    @Override
    public List<Saldo> findAll() {
        return null;
    }

    @Override
    public List<Saldo> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Saldo> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Saldo> findAllById(Iterable<Long> longs) {
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
    public void delete(Saldo entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Saldo> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Saldo> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Saldo> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Saldo> findById(Long aLong) {
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
    public <S extends Saldo> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Saldo> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Saldo> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Saldo getOne(Long aLong) {
        return null;
    }

    @Override
    public Saldo getById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Saldo> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Saldo> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Saldo> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Saldo> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Saldo> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Saldo> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Saldo, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
