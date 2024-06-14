public class MainApp2 {
    public static void main(String[] args) {
        StuManager2 manager = new StuManager2();

        manager.addStudent(new Student(1, "Raman", 19));
        manager.addStudent(new Student(2, "Rahul", 22));
        manager.addStudent(new Student(3, "Charan", 23));

        System.out.println("All Students: " + manager.getAllStudents());

        System.out.println("Student with ID 2: " + manager.getStudentById(2));

        manager.updateStudent(3, "charan", 24);
        System.out.println("Updated Student with ID 2: " + manager.getStudentById(2));

        manager.deleteStudent(1);
        System.out.println("All Students after deletion: " + manager.getAllStudents());
    }
}
