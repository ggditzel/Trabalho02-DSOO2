/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gustavo
 */
@Entity
@Table(name = "QUARTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quartos.findAll", query = "SELECT q FROM Quartos q")
    , @NamedQuery(name = "Quartos.findByNumero", query = "SELECT q FROM Quartos q WHERE q.numero = :numero")
    , @NamedQuery(name = "Quartos.findByTipo", query = "SELECT q FROM Quartos q WHERE q.tipo = :tipo")
    , @NamedQuery(name = "Quartos.findByDiaria", query = "SELECT q FROM Quartos q WHERE q.diaria = :diaria")
    , @NamedQuery(name = "Quartos.findByCamacasal", query = "SELECT q FROM Quartos q WHERE q.camacasal = :camacasal")
    , @NamedQuery(name = "Quartos.findByCamasolteiro", query = "SELECT q FROM Quartos q WHERE q.camasolteiro = :camasolteiro")
    , @NamedQuery(name = "Quartos.findByBanheira", query = "SELECT q FROM Quartos q WHERE q.banheira = :banheira")
    , @NamedQuery(name = "Quartos.findByFrigobar", query = "SELECT q FROM Quartos q WHERE q.frigobar = :frigobar")
    , @NamedQuery(name = "Quartos.findByAr", query = "SELECT q FROM Quartos q WHERE q.ar = :ar")
    , @NamedQuery(name = "Quartos.findByTv", query = "SELECT q FROM Quartos q WHERE q.tv = :tv")})
public class Quartos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO")
    private Integer numero;
    @Size(max = 20)
    @Column(name = "TIPO")
    private String tipo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DIARIA")
    private BigDecimal diaria;
    @Column(name = "CAMACASAL")
    private Integer camacasal;
    @Column(name = "CAMASOLTEIRO")
    private Integer camasolteiro;
    @Column(name = "BANHEIRA")
    private Integer banheira;
    @Column(name = "FRIGOBAR")
    private Integer frigobar;
    @Column(name = "AR")
    private Integer ar;
    @Column(name = "TV")
    private Integer tv;
    @OneToMany(mappedBy = "quarto")
    private Collection<Estadias> estadiasCollection;

    public Quartos() {
    }

    public Quartos(Integer numero) {
        this.numero = numero;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getDiaria() {
        return diaria;
    }

    public void setDiaria(BigDecimal diaria) {
        this.diaria = diaria;
    }

    public Integer getCamacasal() {
        return camacasal;
    }

    public void setCamacasal(Integer camacasal) {
        this.camacasal = camacasal;
    }

    public Integer getCamasolteiro() {
        return camasolteiro;
    }

    public void setCamasolteiro(Integer camasolteiro) {
        this.camasolteiro = camasolteiro;
    }

    public Integer getBanheira() {
        return banheira;
    }

    public void setBanheira(Integer banheira) {
        this.banheira = banheira;
    }

    public Integer getFrigobar() {
        return frigobar;
    }

    public void setFrigobar(Integer frigobar) {
        this.frigobar = frigobar;
    }

    public Integer getAr() {
        return ar;
    }

    public void setAr(Integer ar) {
        this.ar = ar;
    }

    public Integer getTv() {
        return tv;
    }

    public void setTv(Integer tv) {
        this.tv = tv;
    }

    @XmlTransient
    public Collection<Estadias> getEstadiasCollection() {
        return estadiasCollection;
    }

    public void setEstadiasCollection(Collection<Estadias> estadiasCollection) {
        this.estadiasCollection = estadiasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numero != null ? numero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quartos)) {
            return false;
        }
        Quartos other = (Quartos) object;
        if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.Quartos[ numero=" + numero + " ]";
    }
    
}
