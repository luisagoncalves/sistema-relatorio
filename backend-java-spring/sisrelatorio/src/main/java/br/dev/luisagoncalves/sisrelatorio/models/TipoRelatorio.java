package br.dev.luisagoncalves.sisrelatorio.models;

public enum TipoRelatorio {
    SIMPLES("Simples"),
    COMPLETO("Completo");

    private final String displayType;

    TipoRelatorio(String displayType) {
        this.displayType = displayType;
    }

    public String getDisplayType() {
        return displayType;
    }
}
