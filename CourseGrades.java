/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_hmw1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import jdk.nashorn.internal.runtime.regexp.joni.EncodingHelper;

/**
 *
 * @author MERVE
 */
public class CourseGrades {
    
    String course_name; //kursun ismini ve 
    int numberOfstudent; // kurstaki öğrenci sayısını hesaplamak için değişkenler tanımladım
    LinkedList<Student>students=new LinkedList<>();  //öğrencileri tutan bir liste oluşurdum
    Student head;  //listeyi link list olarak tanımladığım için listenin "baş" kısmını belirtmek için değişkenim


    
    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {  //kursun ismini yazdırmak için set metotu kullandım
        this.course_name = course_name;
    }

    public int getNumberOfstudent() {//öğrenci sayısını burada döndürüüyorum
        return numberOfstudent;
        
    }

    public void setNumberOfstudent(int numberOfstudent) { 
        this.numberOfstudent = numberOfstudent;
        
    }
    
    void printCoursName(){
        System.out.println("Course name="+ course_name); //kurs ismini yazdırdım
       
    }
    
        void addFirst(String name){ 
        Student newStudent=new Student(name); //listeye eklemek için yeni bir newStudent olarak yeni bir öğrenci oluşturuyoeum
        if(head==null){ //eğer listenin başı boş ise yeni öğrenci direkt en başa ekleniyor
            head=newStudent;
        }
        else{
            newStudent.next=head; //liste boş değil ise yeni öğrencinin next'ini başa eşitliyioruz ki en başta yeni öğrenci olsun
            head=newStudent; //baş kısmını da yeni öğrenciye atıyoruz
            
        }
       
        students.addFirst(newStudent); //yukarıda oluşturduğumuz students listesine yeni öğrenciyi en başa ekledim
          numberOfstudent++; //öğrenci sayısını bir arttırdım
    }

    void addLast(String name){
        Student newStudent=new Student(name); //listeye eklemek için yeni bir newStudent olarak yeni bir öğrenci oluşturuyoeum
        
        if(head==null){ //liste boş ise tekrar yeni öğrenci direkt en başa eklenecek çünkü boş olduğu için baş ve son aynı oluyor
            head=newStudent;
        }
        else{ //liste boş değil ise
            Student temp=head;  //geçici bir değişken oluşturuyoruz ve baş kısmına atıyoruz
            while(temp.next!=null){ // listenin sonuna kadar geziyoruz liste null olduğu zaman duracak
                temp=temp.next;
            }
            temp.next=newStudent; //temp'in next'i null'a eşit olmayana kadar listede gezdiğimiz için en sonda temp'in next'ini
                                  // yeni öğrenciye atıyoruz ki listenin en sonunda olsun
        }               
        students.addLast(newStudent); //yukarıda oluşturduğumuz students listenin en sonuna yeni öğrenciyi ekliyourz
        numberOfstudent++; //öğrenci sayısını bir arttırırız   
    }
    
    void remove(String name){ 
        if(head==null) //liste boş ise silme işlemi yapılmıyor
             System.out.println("there is no one to remove from the list");
       
        else{
            Student temp=head; //listeyi gezmek için geçicici değişkn olışturdum
            while(temp.next!=null && temp.next.name!=name){ //listenin null olana kadar ve silmek istediğimiz isime kadar 
                temp=temp.next; //listede ilerliyoruz
            }
            if(temp.next!=null && temp.next.name==name){ // eğer aradığımız isim geçici değişkenimizin bir sonrakine eşit ise
                System.out.println(temp.next.name+" silindi"); //silinecek olan kişinin ismini yazdırdım
                students.remove(temp.next); //students listemizden de kişiyi burada sildirdim
                temp.next=temp.next.next; //link listede de geçici değişkenimizin sıradaki kişisini bir sonraki kişiye eşitleyerek
                                          //kişiyi listeden çıkarmış olduk
                  numberOfstudent--; //öğrenci sayısını bir azaltırız
              
               
            }else { //eğer aradığımız isim listede yok ise bir silme işlemi gerçekleşmeyecek bu yüzden öğrenci sayısında da azalma
                    //olmayacak
                
             System.out.println(name + " -> this person is not in the list, please check");
            }
            
     
        } 
        
      
    }
    
        void insertAfter(String name,String search){ 
                                                     //bu kısımda da yukarıda yaptığımız işlemler gibi listeyi dolaşıcağız
        Student temp=head;                          // bu sefer hangi isimden sonra eklemek istiyorsak o isme kadar listede
        int indeks;                                 //ilerleyeceğiz
        
        while(temp!=null && temp.name!=search){  //temp null olmayana kadadar ve aradığımız isime eşit olmayana kadar
            temp=temp.next;                      //listeyi geziyoruz
       }
        if(temp!=null){
            Student newStudent=new Student(name);  //liste boş değilse eklemek istediğimiz yeni öğrencinin sıradakisini 
            newStudent.next=temp.next;             //geçici değişkenimizin sıradakisine eşitliyoruz
            temp.next=newStudent;                  //geçici değişkenimizin sıradaki kişisini yeni öğrenciye atıyoruz bu şekilde
                                                   //yeni öğrenciyi istediğimiz kişinin arasına eklemiş oluyoruz
            indeks=students.indexOf(newStudent.next);         //burada students listemize eklemeyi doğru sırada yapabilmek için indeksini buluyoruz
            students.add(indeks, newStudent); //ve indeksine göre yeni öğrenciyi ekliyoruz
               
        } else{
            addLast(name); // diğer koşulda ise direkt en sona ekleme yaparız bunun için önceden oluşturduğumuz metotu kullandım
       
      }  
        numberOfstudent++; //öğrenci sayısını bir arttırırız
        
    
 }
    
    
    
  void removeLast(){
        if(head==null)
            System.out.println("Listede silinecek eleman yok"); //liste boş ise işlem yapılmıyacak
        else if(head.next==null){
            System.out.println(head.name+" silindi"); //eğer liste bir kişi var ise direkt head null'a eşitlenerek silinecek
            head=null;
        }
        else{
            Student temp=head;
            while(temp.next.next!=null){ //temmp'in next'inin next'i null olmayana kadar
                temp=temp.next;          //tüm listeyi gezeriz
            }
            System.out.println(temp.next.name +" silindi"); ///temp'in nextinin nexti null olmayana kkadar ilerlediğimiz için
            temp.next=null; // temp'in nextinin null'a eşitleriz bu şekilde listenin sonundaki kişiyi kaybetmiş
                            //ve listenin sonundaki kişi artık temp'in next'i olur
            students.removeLast(); //students listemizin sonunda da silme işlemini gerçekleştiririz
        }
        numberOfstudent--; //öğrenci sayısını bir azaltırız
    }
  
  
       void removeFirst(){
        if(head==null) //liste boş ise işlem yapılmayacak
            System.out.println("Listede Silinecek eleman yok");
        else{
            System.out.println(head.name+" silindi"); //listenin başının yani ilk kişinin ismini silindi olarak yazdırdım
             head=head.next;  //head'i head'in next'ine atarız bu şekilde listenin en başındaki kişiyi kaybetmiş oluruz
             students.removeFirst(); //students listemizden de en baştan silme işlemini gerçekleştiririz
        }
        numberOfstudent--; //öğrenci sayısını bir azalttım
       
    }

  
    void randomGrades(){
         
        for (int i = 0; i < students.size(); i++) { //students listemizi for ile döndüm

        Random rnd=new Random(); //random sayı atamak için random fonksşyonunu kullandım
        students.get(i).grade=rnd.nextInt(100); //0-100 arası random sayıları students listesindeki öğrencilere atadım
        if(students.get(i).grade>=0 && students.get(i).grade<60){ //eğer sayı 0 ve 60 arasında ise F
           
            System.out.println(students.get(i).name+ " -> " + students.get(i).grade+ " -> F"); //öğrencinin adını notunu ve 
                                                                                              //harf notunu yazdırdım
        }else if(students.get(i).grade>=60 && students.get(i).grade<75){ //eğer sayı 60 ve 70 arasında ise C
             System.out.println(students.get(i).name+ " -> "+ students.get(i).grade+ " -> C"); //öğrencinin adını notunu ve 
                                                                                               //harf notunu yazdırdım
        }else if(students.get(i).grade>=75 && students.get(i).grade<90){ //eğer sayı 60 ve 70 arasında ise B
         System.out.println(students.get(i).name+ " -> "+ students.get(i).grade+ " -> B");//öğrencinin adını notunu ve 
                                                                                          //harf notunu yazdırdım
        }else if(students.get(i).grade>=90 && students.get(i).grade<100){ //eğer sayı 60 ve 70 arasında ise A
         System.out.println(students.get(i).name+ " -> "+ students.get(i).grade+ "-> A"); //öğrencinin adını notunu ve 
                                                                                          //harf notunu yazdırdım
        }
         
           
        }
          
    }

    
 
   
    
    void print_names(char harfN){
        
        for (int i = 0; i < students.size(); i++){ //students listesindeki öğrencileri for döngüsü ile döndüm
       if(harfN=='A' &&students.get(i).grade >=90 ){ //eğer parametre olarak girilen harf notu A'ya eşitse ve 90dan büyükse
           System.out.println("who get "+ harfN+ " from course -> " + students.get(i).name);//öğrencinin harf notunu ve ismini yazdırdım 
                                                                                             
            }else if(harfN=='B' && students.get(i).grade >=75 && students.get(i).grade <90){//eğer parametre olarak girilen harf notu B'ya eşitse 
             System.out.println("who get "+ harfN+ " from course -> " + students.get(i).name); //ve 90 ile 75 arasında ise yazdırdım
                
            }else if(harfN=='C' &&students.get(i).grade >=60 && students.get(i).grade <75  ){//aynı işlemleri diğer koşular için
                                                                                             //tekrar ettim
                  System.out.println("who get "+ harfN+ " from course -> " + students.get(i).name);
                  
            }else if(harfN=='F' && students.get(i).grade >=0 && students.get(i).grade <60 ){
               System.out.println("who get "+ harfN+ " from course -> " + students.get(i).name);
                    
            }
          
       }
        if(harfN!='A' && harfN!='B' && harfN!='C' && harfN!='F' ){ //eğer geçersiz bir harf girilirse mesaj yazdırdım
           System.out.println( harfN +" -> invalid letter"); 
            
        }
        
      
    }   
    
    
    void print(){
        Student temp=head; //head değişkenini kaybetmemek için bir değişken tanımladım
        while(temp!=null){  //link listim yazdırmak için temp null olmadığı sürece
            System.out.print(temp.name+" -> ");
            temp=temp.next; //temp'in next'ine 
        }
        System.out.println("null");
    }
    
       void printList(){ //LinkedList türündeki students listemi yazdırmak için 
           
           for (int i = 0; i < students.size(); i++) { //öğrencilerin boyu kadar listeyi dönüp
             System.out.println(students.get(i).name);   //öğrencilerin isimlerine get metotduyla ulaşığ yazdırdım 
                
           }
    }
    
  
}
