package com.example.guilh.gerenciadordefilhos.tabelas;

public class tableEventosDosFilhos {
    private static  final String TABLE = "eventos_dos_filhos";

    private Integer filho_id;
    private Integer eventos_id;

    public Integer getFilho_id() {
        return filho_id;
    }

    public void setFilho_id(Integer filho_id) {
        this.filho_id = filho_id;
    }

    public Integer getEventos_id() {
        return eventos_id;
    }

    public void setEventos_id(Integer eventos_id) {
        this.eventos_id = eventos_id;
    }

    private static final String CREATE =
            "CREATE TABLE IF NOT EXISTS " + TABLE + " ( " +
                    "filho_id int(10) unsigned NOT NULL," +
                    "eventos_id int(10) unsigned NOT NULL," +
                    "PRIMARY KEY ( filho_id , eventos_id)," +
                    "KEY filho_has_eventos_FKIndex1 ( filho_id )," +
                    "KEY filho_has_eventos_FKIndex2 ( eventos_id )," +
                    "CONSTRAINT eventos_dos_filhos_ibfk_1 FOREIGN KEY (filho_id) REFERENCES filho (filho_id) ON DELETE NO ACTION ON UPDATE NO ACTION, " +
                    "CONSTRAINT eventos_dos_filhos_ibfk_2 FOREIGN KEY (eventos_id) REFERENCES eventos (eventos_id) ON DELETE NO ACTION ON UPDATE NO ACTION " +
                    ")";

        private static final String DROP = "DROP TABLE IF EXISTS " + TABLE;

        public String create() {
            return CREATE;
        }

        public String upgrade() {
            return DROP;
        }
}
