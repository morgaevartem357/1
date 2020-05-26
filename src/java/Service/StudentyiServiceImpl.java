/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import entity.Gruppyi;
import entity.Studentyi;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import servlets.*;
/**
 *
 * @author User
 */
//Сеаносовый компонент без сохранения состояния
@Stateless
public class StudentyiServiceImpl implements StudentyiService {
private Session session; 
//открытие сессии
     public StudentyiServiceImpl(){
      SessionFactory sf = NewHibernateUtil.getSessionFactory();
      session = sf.openSession();
     
   }
  //переопределяем все методы интерфейса
     
    @Override
    public List getTableStudentyi() {
        org.hibernate.Query query =   this.session.createQuery("from Studentyi student"); 
          List st = (List)query.list();
          //t.commit();
          System.out.println("go");
          return st;
       
    }

    @Override
    public Studentyi getStudent(long id) { 
        org.hibernate.Query query =   this.session.createQuery("from Studentyi s where s.nomerZachetki=:id"); 
          query.setParameter("id",id);
          return (Studentyi) query.list().get(0);
              }

    @Override
    public void deleteStudent(long id) {
 Transaction t = this.session.beginTransaction();
        Query q=session.createQuery("DELETE Studentyi s WHERE s.nomerZachetki = :number");

    q.setParameter("number", id);

    q.executeUpdate();
    t.commit();    }

    @Override
    public void createStudent(long nomerZachetki, int gruppyi, String familiya, String imya, String otchestvo, String gorod, String adres, String tel, String status, Date statusDate) {
 
   Transaction t = this.session.beginTransaction();
   Studentyi St =new Studentyi(); 
      St.setNomerZachetki(nomerZachetki);
      St.setStatus(status);
      St.setStatusDate(statusDate);
      St.setFamiliya(familiya);
      St.setImya(imya);
      St.setOtchestvo(otchestvo);
      St.setAdres(adres);
      St.setGorod(gorod);
      St.setGruppyi((Gruppyi) this.session.load(Gruppyi.class,gruppyi));
      St.setTel(tel);
      
      this.session.saveOrUpdate(St);  
      t.commit();    }

    @Override
    public void updateStudent(long nomerZachetki, int gruppyi, String familiya, String imya, String otchestvo, String gorod, String adres, String tel, String status) {
Transaction tx = this.session.beginTransaction();
        Studentyi Stud =getStudent(nomerZachetki);
        Stud.setAdres(adres);
        Stud.setFamiliya(familiya);
        Stud.setImya(imya);
        Stud.setOtchestvo(otchestvo);
        Stud.setNomerZachetki(nomerZachetki);
        Stud.setStatus(status);
        Stud.setTel(tel);
        Stud.setGruppyi((Gruppyi) this.session.load(Gruppyi.class,gruppyi));
        this.session.saveOrUpdate(Stud);
        tx.commit();
    }
}
