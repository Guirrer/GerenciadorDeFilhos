package com.example.guilh.gerenciadordefilhos.tabelas;

/**
 * Created by guilh on 08/04/2018.
 */

public class tableFilho {

        private static  final String TABLE = "filho";

        private static final String CREATE =
                "CREATE TABLE IF NOT EXISTS " + TABLE + " ( " +
                        "id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT, " +
                        "usuario_id INT(10) UNSIGNED NOT NULL, " +
                        "nome VARCHAR(255) NOT NULL, " +
                        "data_nasc DATE NULL DEFAULT NULL, " +
                        "sexo VARCHAR(255) NULL DEFAULT NULL, " +
                        " PRIMARY KEY (id), " +
                        " INDEX filho_FKIndex1 (usuario_id), " +
                        " CONSTRAINT filho_ibfk_1 FOREIGN KEY (usuario_id) REFERENCES usuario (id) ON UPDATE NO ACTION ON DELETE NO ACTION" +
                        ")";

        private static final String DROP = "DROP TABLE IF EXISTS " + TABLE;

        public String create() {
            return CREATE;
        }

        public String upgrade() {
            return DROP;
        }
}
