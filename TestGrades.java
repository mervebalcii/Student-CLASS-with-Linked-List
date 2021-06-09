/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_hmw1;

/**
 *
 * @author MERVE
 */
public class TestGrades {
    public static void main(String[] args) {
        CourseGrades liste=new CourseGrades();
        
       
        liste.setCourse_name("Math course");
        liste.printCoursName();
     
     
        
        liste.addFirst("asude");
        liste.addLast("merve");
        liste.addLast("eylül");
        liste.addFirst("ahmet");
        liste.addFirst("emel");
        liste.addFirst("arda");
        liste.insertAfter("emre", "ahmet");
        liste.insertAfter("rumaysa", "merve");
        liste.addFirst("yesim");
        liste.addFirst("baki");
        liste.addLast("sergen");
        liste.addFirst("defne");
        liste.insertAfter("ela", "defne");
        liste.addLast("tugce");
        liste.addFirst("berk");
        liste.insertAfter("yasemin", "tugce");
        liste.remove("asude");
        
        System.out.println("size -> "+liste.getNumberOfstudent());
        liste.print();
        liste.printList();
        liste.randomGrades(); 
        System.out.println("-------A-------");
        liste.print_names('A');
        System.out.println("-------B-------");
        liste.print_names('B');
        System.out.println("-------C-------");
        liste.print_names('C');
        System.out.println("-------F-------");
        liste.print_names('F');
        liste.print_names('G');
        System.out.println("size -> "+liste.getNumberOfstudent());
        
    
         
               

    }
    
}
