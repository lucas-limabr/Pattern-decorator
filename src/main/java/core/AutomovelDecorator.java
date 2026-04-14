package core;

import java.time.LocalDateTime;

public abstract class AutomovelDecorator implements Automovel{

    private final Automovel automovel;

    public AutomovelDecorator(Automovel automovel)
    {
        this.automovel = automovel;
    }

    public abstract float getPercentualAcrescimo();

    public abstract String getItemSerie();

    @Override
    public float getPrecoBase() {
        return this.automovel.getPrecoBase() * (1 + this.getPercentualAcrescimo() / 100);
    }

    @Override
    public String getItensSerie() {
        return this.automovel.getItensSerie() + " - " + this.getItemSerie();
    }


}
