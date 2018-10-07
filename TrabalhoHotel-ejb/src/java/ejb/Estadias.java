/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gustavo
 */
@Entity
@Table(name = "ESTADIAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadias.findAll", query = "SELECT e FROM Estadias e")
    , @NamedQuery(name = "Estadias.findById", query = "SELECT e FROM Estadias e WHERE e.id = :id")
    , @NamedQuery(name = "Estadias.findByEntrada", query = "SELECT e FROM Estadias e WHERE e.entrada = :entrada")
    , @NamedQuery(name = "Estadias.findBySaida", query = "SELECT e FROM Estadias e WHERE e.saida = :saida")
    , @NamedQuery(name = "Estadias.findBySenha", query = "SELECT e FROM Estadias e WHERE e.senha = :senha")
    , @NamedQuery(name = "Estadias.findByRestaurante", query = "SELECT e FROM Estadias e WHERE e.restaurante = :restaurante")})
public class Estadias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Column(name = "ENTRADA")
    @Temporal(TemporalType.DATE)
    private Date entrada;
    @Column(name = "SAIDA")
    @Temporal(TemporalType.DATE)
    private Date saida;
    @Size(max = 4)
    @Column(name = "SENHA")
    private String senha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "RESTAURANTE")
    private BigDecimal restaurante;
    @JoinTable(name = "ESTADIASXSERVICOS", joinColumns = {
        @JoinColumn(name = "IDESTADIA", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "IDSERVICO", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Servicos> servicosCollection;
    @JoinColumn(name = "CPF", referencedColumnName = "CPF")
    @ManyToOne
    private Clientes cpf;
    @JoinColumn(name = "QUARTO", referencedColumnName = "NUMERO")
    @ManyToOne
    private Quartos quarto;

    public Estadias() {
    }

    public Estadias(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Date getSaida() {
        return saida;
    }

    public void setSaida(Date saida) {
        this.saida = saida;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public BigDecimal getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(BigDecimal restaurante) {
        this.restaurante = restaurante;
    }

    @XmlTransient
    public Collection<Servicos> getServicosCollection() {
        return servicosCollection;
    }

    public void setServicosCollection(Collection<Servicos> servicosCollection) {
        this.servicosCollection = servicosCollection;
    }

    public Clientes getCpf() {
        return cpf;
    }

    public void setCpf(Clientes cpf) {
        this.cpf = cpf;
    }

    public Quartos getQuarto() {
        return quarto;
    }

    public void setQuarto(Quartos quarto) {
        this.quarto = quarto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadias)) {
            return false;
        }
        Estadias other = (Estadias) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.Estadias[ id=" + id + " ]";
    }
    
}
