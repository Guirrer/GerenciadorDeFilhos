package com.example.guilh.gerenciadordefilhos.tabelas;

public class tableProdutoFilho {
    private static  final String TABLE = "produto_filho";

    private static final String CREATE =
            "CREATE TABLE IF NOT EXISTS " + TABLE + " ( " +
                    "id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT, " +
                    "produto_id INT(10) UNSIGNED NOT NULL, " +
                    "filho_id INT(10) UNSIGNED NOT NULL , " +
                    "loja_compra VARCHAR(255) NULL DEFAULT NULL, " +
                    "qtd_pacote INT(11) NULL DEFAULT NULL, " +
                    "data_compra DATE NULL DEFAULT NULL, " +
                    "preco INT(10) UNSIGNED NULL DEFAULT NULL, " +
                    "detalhe TEXT, " +
                    "qtd_compra INT(11) NULL DEFAULT NULL, " +
                    "PRIMARY KEY (id), " +
                    "INDEX produto_FKIndex1 (filho_id), " +
                    "INDEX produto_filho_FKIndex2 (produto_id), " +
                    "CONSTRAINT produto_filho_ibfk_1 FOREIGN KEY (filho_id) REFERENCES filho (id) ON DELETE NO ACTION ON UPDATE NO ACTION" +
                    "CONSTRAINT produto_filho_ibfk_2 FOREIGN KEY (produto_id) REFERENCES produto (id) ON DELETE NO ACTION ON UPDATE NO ACTION" +
                    ")";

    private static final String DROP = "DROP TABLE IF EXISTS " + TABLE;

    public String create() { return CREATE; }

    public String upgrade() { return DROP; }
}
