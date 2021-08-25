package spring5_mybatis_study.dto;

public class CourseEnrollment {
	private Student student;
	private Course course;
	
	public CourseEnrollment() {
	}
	public CourseEnrollment(Student student, Course course) {
		super();
		this.student = student;
		this.course = course;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return String.format("CourseEnrollment [student=%s, course=%s]", student, course);
	}
	
	
}
