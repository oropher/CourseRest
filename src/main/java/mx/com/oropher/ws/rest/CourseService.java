package mx.com.oropher.ws.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import mx.com.oropher.ws.rest.model.Course;

@Consumes("application/xml,application/json")
@Produces("application/xml,application/json")
@Path("/courseService")
public interface CourseService {
	
	@Path("/courses")
	@GET
	public List<Course> getCourses();
	
	@Path("/courses/{id}")
	@GET
	public Course getCourse(@PathParam(value = "id") Long id);
	
	@Path("/courses")
	@POST
	public Response createCourse(Course course);
	
	@Path("/courses")
	@PUT
	public Response updateCourse(Course course);
	
	@Path("/courses/{id}")
	@DELETE
	public Response deletePatient(@PathParam(value = "id") Long id);

}
