package mx.com.oropher.ws.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import mx.com.oropher.ws.rest.model.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	private Map<Long, Course> courseMap = new HashMap<>();
	private long currentId = 123;
	
	public CourseServiceImpl() {
		Course course = new Course();
		course.setId(currentId);
		course.setName("Curso Magnifico 10/10 de Java");
		course.setPrice(999.98);
		course.setRating(10);
		course.setTaughtBy("Oropher D'Lioncourt");
		
		courseMap.put(currentId, course);
	}

	@Override
	public List<Course> getCourses() {
		return courseMap.values().stream().collect(Collectors.toList());
	}

	@Override
	public Course getCourse(Long id) {
		return courseMap.get(id);
	}

	@Override
	public Response createCourse(Course course) {
		course.setId(++currentId);
		courseMap.put(course.getId(), course);
		return Response.ok(course).build();
	}

	@Override
	public Response updateCourse(Course course) {
		Response response;
		Course currentCourse = courseMap.get(course.getId());
		if(currentCourse != null) {
			courseMap.put(course.getId(), course);
			response = Response.ok(course).build();
		} else {
			response = Response.notModified().build();
		}
		return response;
	}

	@Override
	public Response deletePatient(Long id) {
		Response response;
		Course currentCourse = courseMap.get(id);
		if(currentCourse != null) {
			courseMap.remove(id);
			response = Response.ok().build();
		} else {
			response = Response.notModified().build();
		}
		return response;
	}

}
