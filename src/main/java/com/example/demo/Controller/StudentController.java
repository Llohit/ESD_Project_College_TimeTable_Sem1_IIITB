package com.example.demo.Controller;

import com.example.demo.Bean.Course;
import com.example.demo.Bean.Student;
import com.example.demo.Bean.Studtable;
import com.example.demo.DAO.DAOImplementation.StudentDAOImpl;
import com.example.demo.DAO.StudentDAO;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


import java.net.URISyntaxException;
import java.util.List;

@Path("/employee")
public class StudentController extends Application {

    StudentDAO studentDAO=new StudentDAOImpl();
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response add_Student(Student student){
        System.out.printf(String.valueOf(student));
        if(studentDAO.addStudent(student)){
            return Response.status(200).entity("Success").build();
        }

        return Response.status(400).entity("Failure while adding department").build();
    }




    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginStudent(Student student) {

        Student result = studentDAO.roll_numberVerify(student);

        if(result == null){
            return Response.noContent().build();
        }

        return Response.ok().entity(result).build();
    }


    @POST
    @Path("/courseid")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response studentcourse(Student student) {

        List<Studtable> courseslist = studentDAO.getCourse(student);
        System.out.println(courseslist.get(0).getRoom());
        System.out.println(courseslist.get(0).getFaculty_name());

        if(courseslist.size()!=0)
        {
            return Response.ok().entity(courseslist).build();
        }
        else{
            return Response.status(203).build();
        }
    }



}