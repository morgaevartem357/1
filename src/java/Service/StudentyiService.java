package Service;

import entity.Studentyi;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 
 */
//включаем в проект интерфейс 
//Local - сообщает контейнеру, что реальзация этого интерфейса  мб доступна
//локально, посредством интерфейса
@Local
public interface StudentyiService {
    //методы интерфейса, которыем мы будем переопределять в StudentyiServiceImpl
    List getTableStudentyi();
    Studentyi getStudent(long id);
    void deleteStudent(long id);
    void createStudent(long nomerZachetki, int gruppyi, String familiya, String imya, String otchestvo, String gorod, String adres, String tel, String status, Date statusDate);
    void updateStudent(long nomerZachetki, int gruppyi, String familiya, String imya, String otchestvo, String gorod, String adres, String tel, String status);
   
}