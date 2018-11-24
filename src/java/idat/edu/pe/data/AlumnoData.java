/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idat.edu.pe.data;

import idat.edu.pe.entidades.Alumno;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author LuisAngel
 */
public class AlumnoData {
        Session session = null;
        
            /* Se crea el constructor de la clase con la creación de la sesión
    HIBERNATE que finalmente accede a la base de datos.
    */
    public AlumnoData() {
        this.session = NewHibernateUtil.getSessionFactory()
                .getCurrentSession();
    }
    
    public List<Alumno> ListarAlumno(){
        Transaction trans = session.beginTransaction();
        List<Alumno> lstAlumno = null;
        try{
            Query qr = session.createQuery("from Alumno");
            lstAlumno = (List<Alumno>)qr.list();
            trans.commit();
        }catch(Exception ex){
            ex.printStackTrace();
            trans.rollback();
        }
        return lstAlumno;
    }    
}
