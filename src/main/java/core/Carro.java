package core;

import java.time.LocalDateTime;

public class Carro implements Automovel {

    private String modelo;
    private float precoBase;
    String AIRBAG = "AIRBAG - ";
    String SENSOR_RE = "SENSOR DE RÉ - ";

    public Carro(float precoBase, String modelo)
    {
        this.precoBase = precoBase;
        this.modelo = modelo;
    }

    public Carro() {}

    @Override
    public float getPrecoBase() {
        return precoBase;
    }

    @Override
    public String  getItensSerie() {
        return "Carro - Itens de Série: " + AIRBAG + SENSOR_RE;
    }

    public String getModelo() {
        return modelo;
    }
}
