package core;

public class CambioAutomatico extends AutomovelDecorator{

    public CambioAutomatico(Automovel automovel) {
        super(automovel);
    }

    @Override
    public float getPercentualAcrescimo() {
        return 20.0f;
    }

    @Override
    public String getItemSerie() {
        return "Câmbio Automático -";
    }
}
