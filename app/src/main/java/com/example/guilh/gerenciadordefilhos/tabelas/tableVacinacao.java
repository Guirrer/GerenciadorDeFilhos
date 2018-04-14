package com.example.guilh.gerenciadordefilhos.tabelas;

public class tableVacinacao {
    private static  final String TABLE = "vacinacao";

    private static final String CREATE =
            "CREATE TABLE IF NOT EXISTS " + TABLE + " ( " +
                    "vacinas_id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT, " +
                    "filho_id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT, " +
                    "data_vacina DATE NOT NULL, " +
                    "PRIMARY KEY (vacinas_id, filho_id), " +
                    "INDEX vacinas_has_filho_FKIndex1 (vacinas_id), " +
                    "INDEX vacinas_has_filho_FKIndex2 (filho_id), " +
                    "CONSTRAINT vacinacao_ibfk_1 FOREIGN KEY (vacinas_id) REFERENCES vacinas (id) ON DELETE NO ACTION ON UPDATE NO ACTION" +
                    "CONSTRAINT vacinacao_ibfk_2 FOREIGN KEY (filho_id) REFERENCES filho (id) ON DELETE NO ACTION ON UPDATE NO ACTION" +
                    ")";

    private static final String DROP = "DROP TABLE IF EXISTS " + TABLE;

    public String create() { return CREATE; }

    public String upgrade() { return DROP; }
}
