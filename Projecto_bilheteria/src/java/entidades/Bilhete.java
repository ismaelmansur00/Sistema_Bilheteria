/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ismae
 */
@Entity
@Table(name = "bilhete")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bilhete.findAll", query = "SELECT b FROM Bilhete b"),
    @NamedQuery(name = "Bilhete.findByCodigo", query = "SELECT b FROM Bilhete b WHERE b.codigo = :codigo"),
    @NamedQuery(name = "Bilhete.findByCategoria", query = "SELECT b FROM Bilhete b WHERE b.categoria = :categoria"),
    @NamedQuery(name = "Bilhete.findByDataCompra", query = "SELECT b FROM Bilhete b WHERE b.dataCompra = :dataCompra"),
    @NamedQuery(name = "Bilhete.findByTipoBilhete", query = "SELECT b FROM Bilhete b WHERE b.tipoBilhete = :tipoBilhete"),
    @NamedQuery(name = "Bilhete.findByQuantidade", query = "SELECT b FROM Bilhete b WHERE b.quantidade = :quantidade")})
public class Bilhete implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Size(max = 20)
    @Column(name = "categoria")
    private String categoria;
    @Column(name = "data_compra")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCompra;
    @Size(max = 50)
    @Column(name = "tipo_bilhete")
    private String tipoBilhete;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade")
    private int quantidade;
    @JoinColumn(name = "evento_id", referencedColumnName = "codigo")
    @ManyToOne
    private Evento eventoId;
    @JoinColumn(name = "espectador_id", referencedColumnName = "codigo")
    @ManyToOne
    private Utilizador espectadorId;

    public Bilhete() {
    }

    public Bilhete(Integer codigo) {
        this.codigo = codigo;
    }

    public Bilhete(Integer codigo, int quantidade) {
        this.codigo = codigo;
        this.quantidade = quantidade;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getTipoBilhete() {
        return tipoBilhete;
    }

    public void setTipoBilhete(String tipoBilhete) {
        this.tipoBilhete = tipoBilhete;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Evento getEventoId() {
        return eventoId;
    }

    public void setEventoId(Evento eventoId) {
        this.eventoId = eventoId;
    }

    public Utilizador getEspectadorId() {
        return espectadorId;
    }

    public void setEspectadorId(Utilizador espectadorId) {
        this.espectadorId = espectadorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bilhete)) {
            return false;
        }
        Bilhete other = (Bilhete) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Bilhete[ codigo=" + codigo + " ]";
    }
    
}
