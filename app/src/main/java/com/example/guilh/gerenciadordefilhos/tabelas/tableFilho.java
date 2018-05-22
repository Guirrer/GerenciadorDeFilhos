package com.example.guilh.gerenciadordefilhos.tabelas;

public class tableFilho {
    private static  final String TABLE = "filho";

    private Integer usuario_id;
    private String nome;
    private String data_nasc;
    private String sexo;

    public Integer getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Integer usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

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
