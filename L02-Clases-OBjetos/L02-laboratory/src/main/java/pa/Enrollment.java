/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa;


public class Enrollment {

    
    public static void main(String[] args) {
    	
    	System.out.println("Student's list:");
    	 System.out.println();
    	Student s1 = new Student("Monica Geller", "A00234");
        Student s2 = new Student("Joe Tribiani", "C22044");
        Student s3 = new Student("Chandler Bing", "A12003");
        Student s4 = new Student("Rachel Green", "B66003");
        
        s1.print();
        s2.print();
        s3.print();
        s4.print();
        System.out.println();
        System.out.println("Enroll students (Eli)");
        
        
        s1.addCredits(24);
        s2.addCredits(56);
        s3.addCredits(6);
        s4.addCredits(12);
        
        LabClass l1=new LabClass(2);
        LabClass l2=new LabClass(1);
        
        l1.enrollStudent(s1);
        l1.enrollStudent(s2);
        l1.setTime("Miércoles, 15h");
        l1.setInstructor("Eli");
        l1.setRoom("Aulario 2");
        System.out.println();
        System.out.println("Enroll students (Jose Antonio)");
        l2.enrollStudent(s3);
        l2.enrollStudent(s4);
        l2.setTime("Miércoles, 17h");
        l2.setRoom("Aulario 2");
        l2.setInstructor("Jose Antonio");
        
        l1.printList();
        l2.printList();
    }
    
}
