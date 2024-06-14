public class MainApp {
    public static void main(String[] args) {
        StuManager manager = new StuManager();

        manager.addStudent(new Student(1, "hanuma", 20));
        manager.addStudent(new Student(2, "surya", 27));
        manager.addStudent(new Student(3, "rohith", 25));

        System.out.println("All Students: " + manager.getAllStudents());

        System.out.println("Student with ID 2: " + manager.getStudentById(2));

        manager.updateStudent(2, "surya", 24);
        System.out.println("Updated Student with ID 2: " + manager.getStudentById(2));

        manager.deleteStudent(1);
        System.out.println("All Students after deletion: " + manager.getAllStudents());
    }
}
