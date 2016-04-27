package abd.p1.model;

public enum Genero {
    MASCULINO("Masculino"), FEMENINO("Femenino");

    private String genero;

    Genero() {

    }

    Genero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return genero;
    }
}
