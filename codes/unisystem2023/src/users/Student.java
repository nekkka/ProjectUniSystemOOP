package users;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import courses.Courses;
import enums.Faculty;
import enums.OrganizationName;
import unisystem2023.CanBeResearcher;
import unisystem2023.Mark;
import unisystem2023.Transcript;

public class Student extends User implements CanBeResearcher, Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Faculty faculty;
    private int yearOfStudy;
    private double GPA;
    private OrganizationName member;
    private HashMap<Courses,Mark> courses;
    private HashMap<Courses, Mark> coursesAndMarks;

    public Student() {
        super();
        courses = new HashMap<>();
    }

    public Student(Long id, String login, String password, String name, String surname,
                   String phoneNumber, String email, Faculty faculty, int yearOfStudy,
                   double GPA, OrganizationName member, HashMap<Courses,Mark> courses) {
        super(id, login, password, name, surname, phoneNumber, email); 
        this.faculty = faculty;
        this.yearOfStudy = yearOfStudy;
        this.GPA = GPA;
        this.member = member;
        this.courses = courses;
    }

    // Геттеры и сеттеры 

    public Faculty getFaculty() {
        return this.faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public int getYearOfStudy() {
        return this.yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public double getGPA() {
        return this.GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public OrganizationName getMember() {
        return this.member;
    }

    public void setMember(OrganizationName member) {
        this.member = member;
    }

    public HashMap<Courses,Mark> getCourses() {
        return this.courses;
    }

    public void setCourses(HashMap<Courses,Mark> courses) {
        this.courses = courses;
    }
    
    public HashMap<Courses, Mark> getCoursesAndMarks() {
        return coursesAndMarks;
    }
    


    public void viewAllMarks() {
        Map<Courses, Mark> coursesAndMarks = getCoursesAndMarks();

        if (coursesAndMarks.isEmpty()) {
            for (Map.Entry<Courses, Mark> entry : coursesAndMarks.entrySet()) {
                Courses course = entry.getKey();
                Mark mark = entry.getValue();
                System.out.println("Course: " + course.getCoursesName() + ", Mark: " + mark.getAtt1()+mark.getAtt2()+mark.getFinalExam());
            }
        } else {
            System.out.println("No marks available");
        }
    }


    public void rateTeacher() {
        // приходите позже, я еще не андерстенд как реализовать
    }


    public void viewCourses() {
        for (Map.Entry<Courses, Mark> entry : courses.entrySet()) {
            Courses course = entry.getKey();
            System.out.println(course);
        }
    }


   /* public boolean addCourse(Courses c){
        // Check prerequisites, credits, faculty
        // Add the course with a default mark
        courses.put(c, new Mark());
        return true;
    }*/
    
    public boolean register(Courses course) {
        // Check if the student is eligible to register for the course based on prerequisites, credits, etc.
        // You need to implement the logic based on your application's requirements

        // For demonstration purposes, let's assume the student can register for any course without restrictions
        if (course != null) {
            // Check if the course is not already registered
            if (!courses.containsKey(course)) {
                // Add the course with a default mark
                courses.put(course, new Mark());
                return true; // Successfully registered
            } else {
                // Student is already registered for this course
                System.out.println("Already registered for this course: " + course.getCoursesName());
                return false; // Failed to register
            }
        } else {
            // Invalid course
            System.out.println("Invalid course");
            return false; // Failed to register
        }
    }

    
    public void dropCourse(Courses course) {
        // Implementation of dropCourse method
        // Drop the specified course from the student's registered courses
        // You need to add appropriate logic to remove the course from the student's registered courses
    }
    

    public Transcript getTranscript() {
        // TODO: Implement the logic to get a transcript
        return null;
    }

    public void viewTeachers() {
        if (courses != null && !courses.isEmpty()) {
            for (Map.Entry<Courses, Mark> entry : courses.entrySet()) {
                Courses course = entry.getKey();
                Teacher lector = course.getLector();
                if (lector != null) {
                    System.out.println("Course: " + course.getCoursesName() + ", Lector: " + lector.getName());
                } else {
                    System.out.println("Course: " + course.getCoursesName() + ", Teacher: Not assigned");
                }
            }
        } else {
            System.out.println("No lessons available.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        // TODO: Implement proper equals method comparing Student objects
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student student = (Student) obj;
        // Add comparison logic based on the fields of Student class
        return this.faculty.equals(student.faculty)
                && this.yearOfStudy == student.yearOfStudy
                && Double.compare(this.GPA, student.GPA) == 0
                && this.member.equals(student.member)
                && this.courses.equals(student.courses);
    }

    public void makeResearch() {
        System.out.println("Тут ченить будет потом, обещаю");
    }
    
    public String toString(){
		return getName()+ ", id is "+getId()+", registered courses:  "+(courses.size()==0?"No courses yet ":courses);
	}
    
    public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courses == null) ? 0 : courses.hashCode());
		result = (int) (prime * result + getId());
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		return result;
	}

   // @Override
    /*public int compareTo(User o) {
        if (o instanceof Student) {
            Student otherStudent = (Student) o;
            return Long.compare(this.getId(), otherStudent.getId());
        }
        return 0;
    }*/

    
    
}
