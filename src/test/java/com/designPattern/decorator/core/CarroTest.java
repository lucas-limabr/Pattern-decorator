package com.designPattern.decorator.core;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarroTest {

    Carro carro;
    float precoBase;
    String modelo;

    @BeforeEach
    void setUp() {
        precoBase = 100000.0f;
        modelo = "Virtus";
    }

    @Test
    @DisplayName("Deve retornar o preço base do carro")
    void deveRetornarPrecoBase() {
        carro = new Carro(precoBase, modelo);
        assertEquals(100000.0, carro.getPrecoBase());
    }

    @Test
    @DisplayName("Deve retornar o modelo do carro como Virtus")
    void deveRetornarModelo() {
        Carro carro = new Carro(precoBase, modelo);
        assertEquals("Virtus", carro.getModelo());
    }

    @Test
    @DisplayName("Deve retornar os itens de série padrão de qualquer carro")
    void deveRetornarItensSeriePadrao() {
        carro = new Carro(precoBase, modelo);
        String itensSerie = carro.getItensSerie();
        assertTrue(itensSerie.contains("AIRBAG"));
        assertTrue(itensSerie.contains("SENSOR DE RÉ"));
    }

    @Test
    @DisplayName("Deve retornar o preço base do carro acrescido do valor com motor elétrico")
    void deveRetornarPrecoBaseCarroComMotorEletrico() {
       carro = new Carro(precoBase, modelo);
       Automovel motorEletrico = new MotorEletrico(carro);
       assertEquals(130000.0, motorEletrico.getPrecoBase(), 0.1);
    }

    @Test
    @DisplayName("Deve retornar o preço base do carro acrescido do valor com teto solar")
    void deveRetornarPrecoBaseCarroComTetoSolar() {
        carro = new Carro(precoBase, modelo);
        Automovel tetoSolar = new TetoSolar(carro);
        assertEquals(110000.0, tetoSolar.getPrecoBase());
    }

    @Test
    @DisplayName("Deve retornar o preço base do carro acrescido do valor com cambio automático")
    void deveRetornarPrecoBaseCarroComCambioAutomatico() {
        carro = new Carro(precoBase, modelo);
        Automovel cambioAutomatico = new CambioAutomatico(carro);
        assertEquals(120000.0f, cambioAutomatico.getPrecoBase(), 0.1);
    }

    @Test
    @DisplayName("Deve retornar o preço base do carro acrescido do valor com motor elétrico e com teto solar")
    void deveRetornarPrecoBaseCarroComMotorEletricoEComTetoSolar()
    {
        carro = new Carro(precoBase, modelo);
        Automovel motorEletrico = new MotorEletrico(carro);
        Automovel tetoSolar = new TetoSolar(motorEletrico);
        assertEquals(143000.0, tetoSolar.getPrecoBase());
    }

    @Test
    @DisplayName("Deve retornar o preço base do carro acrescido do valor com motor elétrico, com teto solar e com cambio automático")
    void deveRetornarPrecoBaseCarroComMotorEletricoComTetoSolarEComCambioAutomatico()
    {
        carro = new Carro(precoBase, modelo);
        Automovel motorEletrico = new MotorEletrico(carro);
        Automovel tetoSolar = new TetoSolar(motorEletrico);
        Automovel cambioAutomatico = new CambioAutomatico(tetoSolar);
        assertEquals(171600.0, cambioAutomatico.getPrecoBase());
    }

    @Test
    void deveRetornarItensSerieCarroComMotorEletricoComTetoSolarEComCambioAutomatico()
    {
        carro = new Carro(precoBase, modelo);
        Automovel motorEletrico = new MotorEletrico(carro);
        Automovel tetoSolar = new TetoSolar(motorEletrico);
        Automovel cambioAutomatico = new CambioAutomatico(tetoSolar);
        String itensSerie = "Carro - Itens de Série: AIRBAG - SENSOR DE RÉ - Motor elétrico - Teto Solar - Câmbio Automático";
        assertEquals(itensSerie, cambioAutomatico.getItensSerie());
    }
}