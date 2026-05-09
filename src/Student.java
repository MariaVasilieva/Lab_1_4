public class Student {
    String surname;
    String name;
    int studentID;
    int group;

    Student (String surname, String name, int studentID, int group){
        this.surname = surname;
        this.name = name;
        this.studentID = studentID;
        this.group = group;
    }

    public int getGroup() {
        return group;
    }

    public int getStudentID() {
        return studentID;
    }

    @Override
    public String toString(){
        return String.format("%12s  %10s  %5d  %4d  ", surname, name, studentID, group);
    }
}
