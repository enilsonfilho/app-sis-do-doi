package br.com.sisdodoi.model;

/**
 *
 * @author Enilson Filho
 */
public class PrincipioAtivo {

    private Integer idPrincipioAtivo;
    private String nomePrincipioAtivo;
    private String observacaoPrincipioAtivo;

    public PrincipioAtivo(Integer idPrincipioAtivo, String nomePrincipioAtivo, String observacaoPrincipioAtivo) {
        this.idPrincipioAtivo = idPrincipioAtivo;
        this.nomePrincipioAtivo = nomePrincipioAtivo;
        this.observacaoPrincipioAtivo = observacaoPrincipioAtivo;
    }

    public PrincipioAtivo() {
    }

    /**
     * @return the idPrincipioAtivo
     */
    public Integer getIdPrincipioAtivo() {
        return idPrincipioAtivo;
    }

    /**
     * @param idPrincipioAtivo the idPrincipioAtivo to set
     */
    public void setIdPrincipioAtivo(Integer idPrincipioAtivo) {
        this.idPrincipioAtivo = idPrincipioAtivo;
    }

    /**
     * @return the nomePrincipioAtivo
     */
    public String getNomePrincipioAtivo() {
        return nomePrincipioAtivo;
    }

    /**
     * @param nomePrincipioAtivo the nomePrincipioAtivo to set
     */
    public void setNomePrincipioAtivo(String nomePrincipioAtivo) {
        this.nomePrincipioAtivo = nomePrincipioAtivo;
    }

    /**
     * @return the observacaoPrincipioAtivo
     */
    public String getObservacaoPrincipioAtivo() {
        return observacaoPrincipioAtivo;
    }

    /**
     * @param observacaoPrincipioAtivo the observacaoPrincipioAtivo to set
     */
    public void setObservacaoPrincipioAtivo(String observacaoPrincipioAtivo) {
        this.observacaoPrincipioAtivo = observacaoPrincipioAtivo;
    }

}
