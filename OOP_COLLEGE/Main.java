interface Student {
    void setStudentInfo(String name, int roll, String course);
    void showStudentInfo();
}
interface Teacher {
    void setTeacherInfo(String name, String subject, double salary);
    void showTeacherInfo();
}
class College implements Student, Teacher {
    private String studentName;
    private int rollNo;
    private String course;
    private String teacherName;
    private String subject;
    private double salary;

    public void setStudentInfo(String name, int roll, String course) {
        this.studentName = name;
        this.rollNo = roll;
        this.course = course;
    }

    public void showStudentInfo() {
        System.out.println("Student Name: " + studentName);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Course: " + course);
    }

    public void setTeacherInfo(String name, String subject, double salary) {
        this.teacherName = name;
        this.subject = subject;
        this.salary = salary;
    }

    public void showTeacherInfo() {
        System.out.println("Teacher Name: " + teacherName);
        System.out.println("Subject: " + subject);
        System.out.println("Salary: " + salary);
    }
}

public class Main {
    public static void main(String[] args) s{
        College c = new College();
        c.setStudentInfo("Aayush", 101, "Computer Engineering");
        c.setTeacherInfo("Dr. Sharma", "Data Structures", 55000);
        c.showStudentInfo();
        c.showTeacherInfo();
    }
}