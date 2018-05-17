package com.example.guilh.gerenciadordefilhos.tabelas;

public class tableMedicamento {
    private static  final String TABLE = "medicamento";

    private static final String CREATE =
            "CREATE TABLE IF NOT EXISTS " + TABLE + " ( " +
                    "id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT, " +
                    "nome VARCHAR(255) NOT NULL, " +
                    "laboratorio VARCHAR(255) NOT NULL, " +
                    "finalidade VARCHAR(255) NOT NULL, " +
                    "valor FLOAT NULL DEFAULT NULL, " +
                    "local_compra VARCHAR(255) NULL DEFAULT NULL, " +
                    "qtd INT(10) UNSIGNED NOT NULL, " +
                    "PRIMARY KEY (id), " +
                    ")";

    private static final String DROP = "DROP TABLE IF EXISTS " + TABLE;

    public String create() { return CREATE; }

    public String upgrade() { return DROP; }
}
