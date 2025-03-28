package br.com.teste2.model;

public class DataRow {
    private String[] columns;

    public DataRow(String[] columns) {
        this.columns = columns;
    }

    public String[] getColumns() {
        return columns;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }
}
