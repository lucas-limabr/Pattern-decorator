package com.designPattern.decorator.core;

public class TetoSolar extends AutomovelDecorator{

    public TetoSolar(Automovel automovel) {
        super(automovel);
    }

    @Override
    public float getPercentualAcrescimo() {
        return 10.0f;
    }

    @Override
    public String getItemSerie() {
        return "Teto Solar";
    }
}
