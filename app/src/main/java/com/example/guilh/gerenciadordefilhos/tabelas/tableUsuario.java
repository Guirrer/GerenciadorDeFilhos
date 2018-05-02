package com.example.guilh.gerenciadordefilhos.tabelas;

public class tableUsuario {
    private static  final String TABLE = "usuario";

    private static final String CREATE =
            "CREATE TABLE IF NOT EXISTS " + TABLE + " ( " +
                    "id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT, " +
                    "nome VARCHAR(255) NOT NULL, " +
                    "senha VARCHAR(60) NOT NULL, " +
                    "telefone INT(11) NOT NULL, " +
                    "PRIMARY KEY (id), " +
                    ")";

    private static final String DROP = "DROP TABLE IF EXISTS " + TABLE;

    public String create() { return CREATE; }

    public String upgrade() { return DROP; }
}
