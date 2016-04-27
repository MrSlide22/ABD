package abd.p1.model;

public enum Busca {
    HOMBRES("Hombres"), MUJERES("Mujeres"), AMBOS("Ambos");

    private String busca;

    Busca() {

    }

    Busca(String busca) {
        this.busca = busca;
    }

    @Override
    public String toString() {
        return busca;
    }
}
