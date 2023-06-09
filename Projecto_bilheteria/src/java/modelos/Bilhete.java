package modelos;
// Generated 04-Jun-2023 21:51:48 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Bilhete generated by hbm2java
 */
public class Bilhete  implements java.io.Serializable {


     private Integer codigo;
     private Evento evento;
     private Utilizador utilizador;
     private String categoria;
     private Date dataCompra;
     private String tipoBilhete;
     private int quantidade;

    public Bilhete() {
    }

	
    public Bilhete(int quantidade) {
        this.quantidade = quantidade;
    }
    public Bilhete(Evento evento, Utilizador utilizador, String categoria, Date dataCompra, String tipoBilhete, int quantidade) {
       this.evento = evento;
       this.utilizador = utilizador;
       this.categoria = categoria;
       this.dataCompra = dataCompra;
       this.tipoBilhete = tipoBilhete;
       this.quantidade = quantidade;
    }
   
    public Integer getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public Evento getEvento() {
        return this.evento;
    }
    
    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    public Utilizador getUtilizador() {
        return this.utilizador;
    }
    
    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }
    public String getCategoria() {
        return this.categoria;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public Date getDataCompra() {
        return this.dataCompra;
    }
    
    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }
    public String getTipoBilhete() {
        return this.tipoBilhete;
    }
    
    public void setTipoBilhete(String tipoBilhete) {
        this.tipoBilhete = tipoBilhete;
    }
    public int getQuantidade() {
        return this.quantidade;
    }
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }




}


