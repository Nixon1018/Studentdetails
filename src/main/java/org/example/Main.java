package org.example;

import java.util.*;
import java.util.Scanner;
import java.util.logging.Logger;

class Student{
    String name;
    int age;
    double gpa;
    Student(String name,int age,double gpa)
    {
        this.name=name;
        this.age=age;
        this.gpa=gpa;
    }
}

public class Main {
    private static final Logger LOGGER=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    public static void main(String[] args) {
        ArrayList<Student> test = new ArrayList<Student>();

        Scanner sc= new Scanner(System.in);
        String name;
        int age;
        double gpa;
        int truee=1;

        while(truee!=0) {
            try {
                LOGGER.info("1.add details 2.show 3.exit");
                int check = sc.nextInt();
                if (check == 1) {
                    LOGGER.info("Enter the name");
                    name = sc.next();
                    LOGGER.info("Enter the age");
                    age = sc.nextInt();
                    LOGGER.info("Enter the gpa");
                    gpa = sc.nextDouble();
                    test.add(new Student(name, age, gpa));
                    Collections.sort(test, new Comparator<Student>() {
                        public int compare(Student s1, Student s2) {
                            return Double.compare(s2.gpa, s1.gpa);
                        }


                    });
                } else if (check == 2) {
                    for (int i = 0; i < test.size(); i += 1) {
                        String z = test.get(i).name + " " + test.get(i).age + " " + test.get(i).gpa;
                        LOGGER.info(z);
                    }
                } else if (check == 3) {
                    truee = 0;
                }
            } catch (Exception e)
            {
                String ec = ""+e;
                LOGGER.info(ec);
                sc.nextLine();
            }
        }

    }
}