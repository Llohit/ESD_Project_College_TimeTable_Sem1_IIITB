package com.example.demo.DAO.DAOImplementation;

import com.example.demo.Bean.Course;
import com.example.demo.Bean.Student;
import com.example.demo.DAO.StudentDAO;
import com.example.demo.Bean.Studtable;
import com.example.demo.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public boolean addStudent(Student student) {
        try (Session session = HibernateSessionUtil.getSession()) {  // session created got access of hibernate session object
            Transaction transaction = session.beginTransaction();  // transaction initiated
            session.save(student);                                 // using session object to save java object into MySQL
            transaction.commit();                                  // committing transaction
            return true;
        } catch (HibernateException exception) {
            // if Hibernate Exception occurs return false
            // for related exception we can maintain separate logger
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            return false;
        } catch (Exception e) {
            //generalized exception class for any IO / Arithmetic Exception
            System.out.print(e.getLocalizedMessage());
            return false;
        }
    }
    @Override
    public Student roll_numberVerify(Student student) {
        try (Session session = HibernateSessionUtil.getSession()) {
            session.setProperty("id",student.getRoll_number());

            Query query = session.createQuery("from Student where roll_number=:roll_number");
            query.setParameter("roll_number", student.getRoll_number());

            for(final Object fetch: query.list())
            {
                return (Student) fetch;
            }

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
        return null;
    }




    @Override
    public List<Studtable> getCourse(Student student){
        try (Session session = HibernateSessionUtil.getSession()) {
            Query query = session.createQuery("from Student where roll_number=:roll_number");
            query.setParameter("roll_number", student.getRoll_number());


            for (final Object fetch : query.list()) {
                Student obj = (Student) fetch;
                int c1 = obj.getCourse().get(0).getCourse_id();


                Query query1 = session.createQuery("from Studtable where course_id=:c1");
                query1.setParameter("c1", c1);
                List<Studtable> ret = new ArrayList<>();
                for (final Object fetch1 : query1.list()) {
                    Studtable obj1 = (Studtable) fetch1;
                    ret.add(obj1);
                    System.out.println(obj1.getFaculty_name());
                    System.out.println(obj1.getRoom());
                    System.out.println(obj1.getCourse_name());
                }

                int c2 = obj.getCourse().get(1).getCourse_id();

                Query query2 = session.createQuery("from Studtable where course_id=:c2");
                query2.setParameter("c2", c2);

                for (final Object fetch1 : query2.list()) {
                    Studtable obj2 = (Studtable) fetch1;
                    ret.add(obj2);
                    System.out.println(obj2.getFaculty_name());
                    System.out.println(obj2.getRoom());
                    System.out.println(obj2.getCourse_name());
                }

                int c3 = obj.getCourse().get(2).getCourse_id();

                Query query3 = session.createQuery("from Studtable where course_id=:c3");
                query3.setParameter("c3", c3);

                for (final Object fetch1 : query3.list()) {
                    Studtable obj3 = (Studtable) fetch1;
                    ret.add(obj3);
                    System.out.println(obj3.getFaculty_name());
                    System.out.println(obj3.getRoom());
                    System.out.println(obj3.getCourse_name());
                }


                return ret;
            }
        }catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
        return null;
    }

    @Override
    public Student getStudentByID(Integer id) {
        try (Session session = HibernateSessionUtil.getSession()) {
            return session.get(Student.class, id);
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }


}


