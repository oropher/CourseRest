package mx.com.oropher.ws.rest.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.oropher.ws.rest.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}
