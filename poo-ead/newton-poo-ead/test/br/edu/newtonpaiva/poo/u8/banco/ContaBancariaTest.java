package br.edu.newtonpaiva.poo.u8.banco;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContaBancariaTest {

    private ContaBancaria unit;

    @BeforeEach
    void setUp() throws Exception {
        unit = new ContaBancaria();
        unit.agencia = "0001";
        unit.numero = "12345-6";
    }

    @Test
    void testSacar_comValorValido_resultadoSaqueComSucess() throws DepositoInvalidoException {
        // given
        float saque = 100;
        unit.depositar(120);

        // test
        unit.sacar(saque);

        // assert
        assertEquals(20.0, unit.getSaldo());
    }

    @Test
    void testSacar_comValorInvvalido_resultadoExcecao() throws DepositoInvalidoException {
        // given
        float saque = 100;
        unit.depositar(20);

        try {
            // test
            unit.sacar(saque);

            fail("Esperada excecao SaldoInsuficienteException");

        } catch (SaldoInsuficienteException e) {
            // teste foi bem sucedido
        }

        assertEquals(20.0, unit.getSaldo());
    }

}
