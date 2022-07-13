package controller;

import java.util.List;

import java.util.Map;

import dao.StudentDao;
import dao.StudentDaoImplDatabase;
import exception.PhoneException;
import model.Course;
import model.Registration;
import model.Student;

public class StudentController {
	
	StudentDao dao=new StudentDaoImplDatabase();
	
	public String addNewStudent(Student student) {
		if(student.getPhoneNo().length()!=10) {
			try {
				throw new PhoneException("Invalid phone Number");
			} catch (PhoneException e) {
				return e.getMessage();
			}
		}
		String message=dao.addNewStudent(student);
		return message;

	}

	
	public void updateStudentProfile(Student student) {
		// TODO Auto-generated method stub

	}

	
	public void registration(Student student, Course course) {
		// TODO Auto-generated method stub

	}
	
	public String registrationDb(Registration registration) {
		String message="";
		Student student=dao.findStudentByRollNo(registration.getRollNo());
		Course course=dao.findCourseById(registration.getCourseId());
		if(student!=null) {
			if(course!=null) {
				if(student.getQualification().equals(course.getEligibility())) {
					message=dao.registrationDb(registration);
				}
				else {
					message="You are not eligible.";
				}
			}
			else {
				message="Course not found.";
			}
		}
		else {
			message="Student does not exist.";
		}
		return message;
	}

	
	public Map<Student, Course> viewAllRegistrations() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Student findStudentByRollNo(int rollNo) {
		// TODO Auto-generated method stub
		return dao.findStudentByRollNo(rollNo);
	}

	
	public List<Student> viewAllStudent() {
		
		return dao.viewAllStudent();
	}

	
	public String addNewCourse(Course course) {
		return dao.addNewCourse(course);
	}

	
	public Course findCourseById(int cousreId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<Course> viewAllCourses() {
		// TODO Auto-generated method stub
		return null;
	}

}
