package old.java.Cloning;

/**
 * Created by pandita on 9/30/2015.
 */

class SubjectDeep {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String s) {
        name = s;
    }

    public SubjectDeep(String s) {
        name = s;
    }
}

class StudentDeep implements Cloneable {
    //Contained object
    private Subject subj;

    private String name;

    public Subject getSubj() {
        return subj;
    }

    public String getName() {
        return name;
    }

    public void setName(String s) {
        name = s;
    }

    public StudentDeep(String s, String sub) {
        name = s;
        subj = new Subject(sub);
    }

    public Object clone() {
        //deep copy
        StudentDeep s = new StudentDeep(name, subj.getName());
        return s;
    }
}

public class DeepClone {
    public static void main(String[] args) {
        //Original Object
        StudentDeep stud = new StudentDeep("John", "Algebra");

        System.out.println("Original Object: " + stud.getName() + " - "
                + stud.getSubj().getName());

        //Clone Object
        StudentDeep clonedStud = (StudentDeep) stud.clone();

        System.out.println("Cloned Object: " + clonedStud.getName() + " - "
                + clonedStud.getSubj().getName());

        stud.setName("Dan");
        stud.getSubj().setName("Physics");

        System.out.println("Original Object after it is updated: "
                + stud.getName() + " - " + stud.getSubj().getName());

        System.out.println("Cloned Object after updating original object: "
                + clonedStud.getName() + " - " + clonedStud.getSubj().getName());

    }
}
