package com.example.guilh.gerenciadordefilhos.tabelas;

public class tableVacinas {
    private static  final String TABLE = "vacinas";

    private static final String CREATE =
            "CREATE TABLE IF NOT EXISTS " + TABLE + " ( " +
                    "id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT, " +
                    "nome_vacina VARCHAR(255) NOT NULL, " +
                    "idade_minima INT(11) UNSIGNED NULL DEFAULT NULL, " +
                    "dose INT(11) UNSIGNED NULL DEFAULT NULL, " +
                    "validade FLOAT UNSIGNED NULL DEFAULT NULL, " +
                    "periodicidade FLOAT UNSIGNED NULL DEFAULT NULL, " +
                    "PRIMARY KEY (id), " +
                    ")";

    private static final String DROP = "DROP TABLE IF EXISTS " + TABLE;

    public String create() { return CREATE; }

    public String upgrade() { return DROP; }
}
