package br.com.sisdodoi.model;

/**
 *
 * @author Enilson Filho
 */
public class Remedio {

    private Integer idRemedio;
    private String nomeRemedio;
    private Double precoRemedio;

    public Remedio() {
    }

    public Remedio(Integer idremedio, String nomeremedio, Double precoremedio) {
        this.idRemedio = idremedio;
        this.nomeRemedio = nomeremedio;
        this.precoRemedio = precoremedio;
    }

    /**
     * @return the idRemedio
     */
    public Integer getIdRemedio() {
        return idRemedio;
    }

    /**
     * @param idRemedio the idRemedio to set
     */
    public void setIdRemedio(Integer idRemedio) {
        this.idRemedio = idRemedio;
    }

    /**
     * @return the nomeRemedio
     */
    public String getNomeRemedio() {
        return nomeRemedio;
    }

    /**
     * @param nomeRemedio the nomeRemedio to set
     */
    public void setNomeRemedio(String nomeRemedio) {
        this.nomeRemedio = nomeRemedio;
    }

    /**
     * @return the precoRemedio
     */
    public Double getPrecoRemedio() {
        return precoRemedio;
    }

    /**
     * @param precoRemedio the precoRemedio to set
     */
    public void setPrecoRemedio(Double precoRemedio) {
        this.precoRemedio = precoRemedio;
    }

    public String DoublePrecoRemedio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}