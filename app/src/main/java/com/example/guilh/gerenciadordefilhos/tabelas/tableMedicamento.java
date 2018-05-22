package com.example.guilh.gerenciadordefilhos.tabelas;

public class tableMedicamento {
    private static  final String TABLE = "medicamento";

    private Integer medicamento_id;
    private String nome;
    private String laboratorio;
    private String finalidade;
    private Float valor;
    private String local_compra;
    private Integer qtd;

    public Integer getMedicamento_id() {
        return medicamento_id;
    }

    public void setMedicamento_id(Integer medicamento_id) {
        this.medicamento_id = medicamento_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getLocal_compra() {
        return local_compra;
    }

    public void setLocal_compra(String local_compra) {
        this.local_compra = local_compra;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    private static final String CREATE =
            "CREATE TABLE IF NOT EXISTS " + TABLE + " ( " +
                    "medicamento_id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT, " +
                    "nome VARCHAR(255) NOT NULL, " +
                    "laboratorio VARCHAR(255) NOT NULL, " +
                    "finalidade VARCHAR(255) NOT NULL, " +
                    "valor FLOAT NULL DEFAULT NULL, " +
                    "local_compra VARCHAR(255) NULL DEFAULT NULL, " +
                    "qtd INT(10) UNSIGNED NOT NULL, " +
                    "PRIMARY KEY (medicamento_id), " +
                    ")";

    private static final String DROP = "DROP TABLE IF EXISTS " + TABLE;

    public String create() { return CREATE; }

    public String upgrade() { return DROP; }
}
