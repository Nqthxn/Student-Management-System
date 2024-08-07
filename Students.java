public class Students {
    private String id;
    private String name;
    private int age;
    private char gender;
    private String course = "None";
    private String grade = "None";
    private String courseID = "";
    private String professor = ""; 

    public Students(String studentID, String studentName, int studentAge, char studentGender){
        this.id = studentID;
        this.name = studentName;
        this.age = studentAge;
        this.gender = studentGender;
    }

    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public char getGender(){
        return gender;
    }
    public String getCourse(){
        return course;
    }
    public String getGrade(){
        return grade;
    }

    public void updateInfo(String newName, int newAge, char newGender){
        this.name = newName;
        this.age = newAge;
        this.gender = newGender;
    }

    public void addCourse(String cID, String name, String instructor){
        this.courseID = cID;
        this.course = name;
        this.professor = instructor;
    }

    public String toString(){
        return "Student ID : " + id + "\nName : " + name + "\nAge : " + age + "\nGender : " + gender + "\nEnrolled Courses : " + course + "\nGrades : " + grade;
    }
}
