package com.company;

import java.io.*;
import java.util.UUID;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here

        Person[] people = new Person[3]; //
        people[0] = new Employee(23, "sdadasda");
        people[1] = new Person(34);
        people[2] = new Person(34);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.dat")))
         {
             out.writeObject(people);
         }



        try (ObjectInputStream in = new ObjectInputStream(new
            FileInputStream("employee.dat"))) {
            // retrieve all records into a new array

            Person[] newStaff = (Person[]) in.readObject();

            for (Person person : newStaff) {
                System.out.println(person.getAge());
                if (person instanceof Employee){
                    System.out.println(((Employee)person).getName());
                }
            }

        }

    }
}
