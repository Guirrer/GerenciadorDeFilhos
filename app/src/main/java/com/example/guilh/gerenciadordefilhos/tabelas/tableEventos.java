package com.example.guilh.gerenciadordefilhos.tabelas;

public class tableEventos {
    private static  final String TABLE = "eventos";

    private Integer eventos_id;
    private String datahora_evento;
    private String local_evento;
    private String nome_evento;
    private String descricao;

    public Integer getEventos_id() {
        return eventos_id;
    }

    public void setEventos_id(Integer eventos_id) {
        this.eventos_id = eventos_id;
    }

    public String getDatahora_evento() {
        return datahora_evento;
    }

    public void setDatahora_evento(String datahora_evento) {
        this.datahora_evento = datahora_evento;
    }

    public String getLocal_evento() {
        return local_evento;
    }

    public void setLocal_evento(String local_evento) {
        this.local_evento = local_evento;
    }

    public String getNome_evento() {
        return nome_evento;
    }

    public void setNome_evento(String nome_evento) {
        this.nome_evento = nome_evento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    private static final String CREATE =
            "CREATE TABLE IF NOT EXISTS " + TABLE + " ( " +
                    "eventos_id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT, " +
                    "datahora_evento DATE NOT NULL, " +
                    "local_evento VARCHAR(255) NULL DEFAULT NULL, " +
                    "nome_evento VARCHAR(100) NULL DEFAULT NULL, " +
                    "descricao VARCHAR(255) NULL DEFAULT NULL, " +
                    "PRIMARY KEY (eventos_id), " +
                    ")";

    private static final String DROP = "DROP TABLE IF EXISTS " + TABLE;

    public String create() { return CREATE; }

    public String upgrade() { return DROP; }
}
