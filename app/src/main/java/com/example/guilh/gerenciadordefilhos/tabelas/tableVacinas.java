package com.example.guilh.gerenciadordefilhos.tabelas;

public class tableVacinas {
    private static  final String TABLE = "vacinas";

    private Integer vacina_id;
    private String nome_vacina;
    private Integer idade_minima;
    private Integer dose;
    private Float validade;
    private Float periodicidade;

    public Integer getVacina_id() {
        return vacina_id;
    }

    public void setVacina_id(Integer vacina_id) {
        this.vacina_id = vacina_id;
    }

    public String getNome_vacina() {
        return nome_vacina;
    }

    public void setNome_vacina(String nome_vacina) {
        this.nome_vacina = nome_vacina;
    }

    public Integer getIdade_minima() {
        return idade_minima;
    }

    public void setIdade_minima(Integer idade_minima) {
        this.idade_minima = idade_minima;
    }

    public Integer getDose() {
        return dose;
    }

    public void setDose(Integer dose) {
        this.dose = dose;
    }

    public Float getValidade() {
        return validade;
    }

    public void setValidade(Float validade) {
        this.validade = validade;
    }

    public Float getPeriodicidade() {
        return periodicidade;
    }

    public void setPeriodicidade(Float periodicidade) {
        this.periodicidade = periodicidade;
    }

    private static final String CREATE =
            "CREATE TABLE IF NOT EXISTS " + TABLE + " ( " +
                    "vacina_id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT, " +
                    "nome_vacina VARCHAR(255) NOT NULL, " +
                    "idade_minima INT(11) UNSIGNED NULL DEFAULT NULL, " +
                    "dose INT(11) UNSIGNED NULL DEFAULT NULL, " +
                    "validade FLOAT UNSIGNED NULL DEFAULT NULL, " +
                    "periodicidade FLOAT UNSIGNED NULL DEFAULT NULL, " +
                    "PRIMARY KEY (vacina_id), " +
                    ")";

    private static final String DROP = "DROP TABLE IF EXISTS " + TABLE;

    public String create() { return CREATE; }

    public String upgrade() { return DROP; }
}
