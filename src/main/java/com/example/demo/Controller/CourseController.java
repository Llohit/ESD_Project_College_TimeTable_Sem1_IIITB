package com.example.demo.Controller;

import com.example.demo.Bean.Course;
import com.example.demo.DAO.DAOImplementation.CourseDAOImpl;
import com.example.demo.DAO.CourseDAO;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/department")
public class CourseController {
    CourseDAO deptDAO = new CourseDAOImpl();

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response add_course(Course course){
        System.out.printf(String.valueOf(course));
        if(deptDAO.addCourse(course)){
            return Response.status(200).entity("Success").build();
        }

        return Response.status(400).entity("Failure while adding department").build();
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCourses() {
        List<Course> courses = deptDAO.getCourses();
        return Response.ok().entity(courses).build();
    }

//    @GET
//    @Path("/get_employees/{dept_id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response get_department(@PathParam("dept_id") int d_id){
//        System.out.println(d_id);
//
//        List<Employee> employees = deptDAO.employeeListInDepartment(d_id);
//
//        return Response.status(200).entity(employees).build();
//    }

}