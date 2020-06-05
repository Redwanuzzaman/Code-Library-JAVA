package com.waitnotifynotifyall;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Test1 t = new Test1();
        new Thread(){
            @Override
            public void run(){
                t.salaryCalculation();
            }
        }.start();
        new Thread(){
            @Override
            public void run(){
                t.input();
            }
        }.start();
    }
}

class Test1 {
    int salary1;
    int salary2;
    int perDay1;
    int perDay2;
    
    synchronized void salaryCalculation(){
        try{
            wait();
        } catch(InterruptedException e){
            
        }
        salary1 = 1000 * perDay1;
        salary2 = 750 * perDay2;
        
        System.out.println("Employee 1 This month salary = " + salary1);
        System.out.println("Employee 2 This month salary = " + salary2); 
        
    }
    
    synchronized void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("How Many days Employee 1 worked?: ");
        perDay1 = sc.nextInt();
        System.out.println("How Many days Employee 2 worked?: ");
        perDay2 = sc.nextInt();
        notify();
    }
}


//-----------Output---------------

How Many days Employee 1 worked?: 
10
How Many days Employee 2 worked?: 
15
Employee 1 This month salary = 10000
Employee 2 This month salary = 11250


//------------Working Procedure-------------

# In MainClass class we've crearted two threads of the same object Test1. 
I've used synchronized() method so that no threads can interrupt each other.

# I've called the wait() method in salaryCalculation method. 
Without calling the wait method this method will not run. and the salary will not be calulated.

# Then in the input() method we've notified it with the notify() method. 
Then the salaryCalculation method run. Without notifying the program will run infinte time. 
