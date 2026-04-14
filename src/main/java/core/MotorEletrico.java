package core;

public class MotorEletrico extends AutomovelDecorator{

    public MotorEletrico(Automovel automovel) {
        super(automovel);
    }

    @Override
    public float getPercentualAcrescimo() {
        return 30.0f;
    }

    @Override
    public String getItemSerie() {
        return "Motor elétrico -";
    }
}
