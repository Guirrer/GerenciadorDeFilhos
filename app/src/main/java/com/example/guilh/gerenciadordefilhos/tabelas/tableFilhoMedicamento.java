package com.example.guilh.gerenciadordefilhos.tabelas;

public class tableFilhoMedicamento {
    private static  final String TABLE = "filho_medicamento";

    private static final String CREATE =
            "CREATE TABLE IF NOT EXISTS " + TABLE + " ( " +
                    "idfilho_medicamento INT(10) UNSIGNED NOT NULL AUTO_INCREMENT, " +
                    "filho_id INT(10) UNSIGNED NOT NULL, " +
                    "medicamento_id INT(10) UNSIGNED NOT NULL, " +
                    "dosagem FLOAT UNSIGNED NULL DEFAULT NULL, " +
                    "periodo FLOAT UNSIGNED NULL DEFAULT NULL, " +
                    "observacao VARCHAR(255) NULL DEFAULT NULL, " +
                    "PRIMARY KEY (idfilho_medicamento), " +
                    "INDEX filho_medicamento_FKIndex1 (filho_id), " +
                    "INDEX filho_medicamento_FKIndex2 (medicamento_id), " +
                    "CONSTRAINT filho_medicamento_ibfk_1 FOREIGN KEY (filho_id) REFERENCES filho (id) ON DELETE NO ACTION ON UPDATE NO ACTION" +
                    "CONSTRAINT filho_medicamento_ibfk_2 FOREIGN KEY (medicamento_id) REFERENCES medicamento (id) ON DELETE NO ACTION ON UPDATE NO ACTION" +
                    ")";

    private static final String DROP = "DROP TABLE IF EXISTS " + TABLE;

    public String create() { return CREATE; }

    public String upgrade() { return DROP; }
}
