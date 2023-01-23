package com.github.willyancaetano.junit;

import org.junit.jupiter.api.*;

import java.time.LocalDateTime;


/**
 * BeforeAll / AfterAll executação única no inicio / fim da execução dos testes (ciclo do teste da classe )
 * BeforeEach / AfterEach executa antes / depois de cada teste que existe na classe (se existe 3 testes, executará 3x)
 *
 */
public class ConsultarDadosDePessoaTest {
    @BeforeAll //Executar antes de todos os tetes
    static void configuraConexao() {
        ConexaoComBancoDeDados.iniciarConexao();
    }
    @BeforeEach //A cada teste executado esse operação vai executar antes
    void insereDadosParaTeste(){
        ConexaoComBancoDeDados.insereDados(new Pessoa("João", LocalDateTime.of(2000,1,13,0,0)));
    }
    @AfterEach //A cada teste executado esse operação vai executar depois para remover os dados
    void removeDadosParaTeste(){
        ConexaoComBancoDeDados.removeDados(new Pessoa("João", LocalDateTime.of(2000,1,13,0,0)));
    }
    @Test
    void validarDadosDeRetorno() {
        Assertions.assertTrue(true);
    }
    @Test
    void validarDadosDeRetorno2() {
        Assertions.assertNull(null);
    }

    @AfterAll //Executar depois de todos os tetes
    static void finalizarConexao() {
        ConexaoComBancoDeDados.finalizarConexao();
    }



}

