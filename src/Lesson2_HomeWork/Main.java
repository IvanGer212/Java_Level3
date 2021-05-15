package Lesson2_HomeWork;

public class Main {
    public static void main(String[] args) {
        StudentREpository rEpository = new StudentREpository();
        System.out.println(rEpository.findAll());

        System.out.println(rEpository.findById("User1"));
        //Student student = rEpository.findById(3).get();
        //student.setName("Ivan");
        //System.out.println(rEpository.update(student));
        //System.out.println(rEpository.findAll());

        //System.out.println(rEpository.save(new Student(9, "Vasya", "Pupkin")));
        //System.out.println(rEpository.findAll());
    }
}
