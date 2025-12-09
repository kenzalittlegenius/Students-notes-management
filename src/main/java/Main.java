
public class Main {
    public static void main(String[] args){
        //creation of our object from the class we created
        Student kenza = new Student("Kenza", "Benmansour");
        kenza.addResult("Programmation 2", new Grade(20));
        kenza.addResult("Structures discrètes", new Grade(18));

        Student alice = new Student("Alice", "Durand");
        alice.addResult("Programmation 2", new Grade(15));
        alice.addResult("Structures discrètes", new Grade(17));

        Cohort cohort = new Cohort("L2 Informatique");
        cohort.addStudent(kenza);
        cohort.addStudent(alice);

        cohort.printStudentsResults();

    }
}
