package com.example.demo.DAO.DAOImplementation;

import com.example.demo.Bean.Course;
import com.example.demo.DAO.CourseDAO;

import com.example.demo.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {
    @Override
    public boolean addCourse(Course course) {
        try (Session session = HibernateSessionUtil.getSession()) {  // session created got access of hibernate session object
            Transaction transaction = session.beginTransaction();  // transaction initiated
            session.save(course);                                 // using session object to save java object into MySQL
            transaction.commit();                                  // committing transaction
            return true;
        } catch (HibernateException exception) {
            // if Hibernate Exception occurs return false
            // for related exception we can maintain separate logger / Sysout messages for easy debugging
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
    public boolean registerCourse(Course course) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(course);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public List<Course> getCourses() {
        try (Session session = HibernateSessionUtil.getSession()) {
            List<Course> courses = new ArrayList<>();
            for (final Object d : session.createQuery("from Course ").list()) {
                courses.add((Course) d);
            }
            return courses;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public Course getCourseByID(Integer id) {
        try (Session session = HibernateSessionUtil.getSession()) {
            return session.get(Course.class, id);
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }
}