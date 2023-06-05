/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.Evento;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import persist.HibernateUtil;

/**
 *
 * @author Fenias
 */
public class ImplementarEventoDAO {
    public void inserirCurso(Evento evento) {
        Session sessao=null;
        try{
            sessao=HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            sessao.save(evento);
            sessao.getTransaction().commit();
        }catch(HibernateException e){
            System.out.println(e.getMessage());
            sessao.getTransaction().rollback();
        }finally{
            if(sessao!=null){
                sessao.close();
            }
        }
    }
    
}
