/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ismae
 */
@Entity
@Table(name = "espectador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Espectador.findAll", query = "SELECT e FROM Espectador e"),
    @NamedQuery(name = "Espectador.findByCodigo", query = "SELECT e FROM Espectador e WHERE e.codigo = :codigo"),
    @NamedQuery(name = "Espectador.findByNome", query = "SELECT e FROM Espectador e WHERE e.nome = :nome"),
    @NamedQuery(name = "Espectador.findByBairro", query = "SELECT e FROM Espectador e WHERE e.bairro = :bairro"),
    @NamedQuery(name = "Espectador.findByCidade", query = "SELECT e FROM Espectador e WHERE e.cidade = :cidade"),
    @NamedQuery(name = "Espectador.findByTelefone", query = "SELECT e FROM Espectador e WHERE e.telefone = :telefone")})
public class Espectador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Size(max = 255)
    @Column(name = "nome")
    private String nome;
    @Size(max = 100)
    @Column(name = "bairro")
    private String bairro;
    @Size(max = 100)
    @Column(name = "cidade")
    private String cidade;
    @Size(max = 100)
    @Column(name = "telefone")
    private String telefone;
    @JoinColumn(name = "espectador_id", referencedColumnName = "codigo")
    @ManyToOne
    private Utilizador espectadorId;

    public Espectador() {
    }

    public Espectador(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
        if (!(object instanceof Espectador)) {
            return false;
        }
        Espectador other = (Espectador) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Espectador[ codigo=" + codigo + " ]";
    }
    
}
