package com.example.guilh.gerenciadordefilhos.tabelas;

public class tableFilhoMedicamento {
    private static  final String TABLE = "filho_medicamento";

    private Integer idfilho_medicamento;
    private Integer filho_id;
    private Integer medicamento_id;

    public Integer getIdfilho_medicamento() {
        return idfilho_medicamento;
    }

    public void setIdfilho_medicamento(Integer idfilho_medicamento) {
        this.idfilho_medicamento = idfilho_medicamento;
    }

    public Integer getFilho_id() {
        return filho_id;
    }

    public void setFilho_id(Integer filho_id) {
        this.filho_id = filho_id;
    }

    public Integer getMedicamento_id() {
        return medicamento_id;
    }

    public void setMedicamento_id(Integer medicamento_id) {
        this.medicamento_id = medicamento_id;
    }

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
                    "CONSTRAINT filho_medicamento_ibfk_2 FOREIGN KEY (medicamento_id) REFERENCES medicamento (medicamento_id) ON DELETE NO ACTION ON UPDATE NO ACTION" +
                    ")";

    private static final String DROP = "DROP TABLE IF EXISTS " + TABLE;

    public String create() { return CREATE; }

    public String upgrade() { return DROP; }
}
