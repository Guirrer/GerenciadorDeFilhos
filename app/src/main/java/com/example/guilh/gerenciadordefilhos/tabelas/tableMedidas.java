package com.example.guilh.gerenciadordefilhos.tabelas;

public class tableMedidas {
    private static  final String TABLE = "medidas";

    private static final String CREATE =
            "CREATE TABLE IF NOT EXISTS " + TABLE + " ( " +
                    "id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT, " +
                    "filho_id INT(10) UNSIGNED NOT NULL, " +
                    "data_dado DATE NOT NULL, " +
                    "peso FLOAT UNSIGNED NULL DEFAULT NULL, " +
                    "tam_pe INT(11) UNSIGNED NULL DEFAULT NULL, " +
                    "altura FLOAT NULL DEFAULT NULL, " +
                    "PRIMARY KEY (id), " +
                    "INDEX filho_FKIndex1 (filho_id), " +
                    "CONSTRAINT medidas_ibfk_1 FOREIGN KEY (filho_id) REFERENCES filho (id) ON DELETE NO ACTION ON UPDATE NO ACTION" +
                    ")";

    private static final String DROP = "DROP TABLE IF EXISTS " + TABLE;

    public String create() { return CREATE; }

    public String upgrade() { return DROP; }
}
