package com.example.guilh.gerenciadordefilhos.tabelas;

public class tableProdutoFilho {
    private static  final String TABLE = "produto_filho";

    private Integer produtoFilho_id;
    private Integer produto_id;
    private Integer filho_id;
    private String loja_compra;
    private Integer qtd_pacote;
    private String data_compra;
    private Integer preco;
    private String detalhe;
    private Integer qtd_compra;

    public Integer getProdutoFilho_id() {
        return produtoFilho_id;
    }

    public void setProdutoFilho_id(Integer produtoFilho_id) {
        this.produtoFilho_id = produtoFilho_id;
    }

    public Integer getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(Integer produto_id) {
        this.produto_id = produto_id;
    }

    public Integer getFilho_id() {
        return filho_id;
    }

    public void setFilho_id(Integer filho_id) {
        this.filho_id = filho_id;
    }

    public String getLoja_compra() {
        return loja_compra;
    }

    public void setLoja_compra(String loja_compra) {
        this.loja_compra = loja_compra;
    }

    public Integer getQtd_pacote() {
        return qtd_pacote;
    }

    public void setQtd_pacote(Integer qtd_pacote) {
        this.qtd_pacote = qtd_pacote;
    }

    public String getData_compra() {
        return data_compra;
    }

    public void setData_compra(String data_compra) {
        this.data_compra = data_compra;
    }

    public Integer getPreco() {
        return preco;
    }

    public void setPreco(Integer preco) {
        this.preco = preco;
    }

    public String getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }

    public Integer getQtd_compra() {
        return qtd_compra;
    }

    public void setQtd_compra(Integer qtd_compra) {
        this.qtd_compra = qtd_compra;
    }

    private static final String CREATE =
            "CREATE TABLE IF NOT EXISTS " + TABLE + " ( " +
                    "produtoFilho_id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT, " +
                    "produto_id INT(10) UNSIGNED NOT NULL, " +
                    "filho_id INT(10) UNSIGNED NOT NULL , " +
                    "loja_compra VARCHAR(255) NULL DEFAULT NULL, " +
                    "qtd_pacote INT(11) NULL DEFAULT NULL, " +
                    "data_compra DATE NULL DEFAULT NULL, " +
                    "preco INT(10) UNSIGNED NULL DEFAULT NULL, " +
                    "detalhe VARCHAR(255) NULL DEFAULT NULL, " +
                    "qtd_compra INT(11) NULL DEFAULT NULL, " +
                    "PRIMARY KEY (produtoFilho_id), " +
                    "INDEX produto_FKIndex1 (filho_id), " +
                    "INDEX produto_filho_FKIndex2 (produto_id), " +
                    "CONSTRAINT produto_filho_ibfk_1 FOREIGN KEY (filho_id) REFERENCES filho (id) ON DELETE NO ACTION ON UPDATE NO ACTION" +
                    "CONSTRAINT produto_filho_ibfk_2 FOREIGN KEY (produto_id) REFERENCES produto (produto_id) ON DELETE NO ACTION ON UPDATE NO ACTION" +
                    ")";

    private static final String DROP = "DROP TABLE IF EXISTS " + TABLE;

    public String create() { return CREATE; }

    public String upgrade() { return DROP; }
}
