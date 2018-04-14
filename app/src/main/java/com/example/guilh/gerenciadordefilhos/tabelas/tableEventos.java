package com.example.guilh.gerenciadordefilhos.tabelas;

public class tableEventos {
    private static  final String TABLE = "eventos";

    private static final String CREATE =
            "CREATE TABLE IF NOT EXISTS " + TABLE + " ( " +
                    "id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT, " +
                    "datahora_evento DATE NOT NULL, " +
                    "local_evento VARCHAR(255) NULL DEFAULT NULL, " +
                    "nome_evento VARCHAR(100) NULL DEFAULT NULL, " +
                    "descricao VARCHAR(255) NULL DEFAULT NULL, " +
                    "PRIMARY KEY (id), " +
                    ")";

    private static final String DROP = "DROP TABLE IF EXISTS " + TABLE;

    public String create() { return CREATE; }

    public String upgrade() { return DROP; }
}
