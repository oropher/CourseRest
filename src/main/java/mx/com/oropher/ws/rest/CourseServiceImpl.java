package mx.com.oropher.ws.rest;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.oropher.ws.rest.model.Course;
import mx.com.oropher.ws.rest.repos.CourseRepository;

//@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseRepository repo;
	
	/*private Map<Long, Course> courseMap = new HashMap<>();
	private long currentId = 123;
	
	public CourseServiceImpl() {
		Course course = new Course();
		course.setId(currentId);
		course.setName("Curso Magnifico 10/10 de Java");
		course.setPrice(999.98);
		course.setRating(10);
		course.setTaughtBy("Oropher D'Lioncourt");
		
		courseMap.put(currentId, course);
	}*/

	@Override
	public List<Course> getCourses() {
		//return courseMap.values().stream().collect(Collectors.toList());
		return repo.findAll();
	}

	@Override
	public Course getCourse(Long id) {
		//return courseMap.get(id);
		return repo.findById(id).get();
	}

	@Override
	public Response createCourse(Course course) {
		/*course.setId(++currentId);
		courseMap.put(course.getId(), course);
		return Response.ok(course).build();*/
		Course savedCourse = repo.save(course);
		return Response.ok(savedCourse).build();
	}

	@Override
	public Response updateCourse(Course course) {
		Response response;
		//Course currentCourse = courseMap.get(course.getId());
		Optional<Course> courseFound = repo.findById(course.getId());
		if(courseFound.isPresent()) {
			Course savedCourse = repo.save(course);
			response = Response.ok(savedCourse).build();
		} else {
			response = Response.notModified().build();
		}
		return response;
		
	}

	@Override
	public Response deletePatient(Long id) {
		Response response;
		Optional<Course> courseFound = repo.findById(id);
		if(courseFound.isPresent()) {
			repo.delete(courseFound.get());
			response = Response.ok().build();
		} else {
			response = Response.notModified().build();
		}
		return response;
	}

}
