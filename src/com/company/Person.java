package com.company;

import java.io.IOException;
import java.io.Serializable;

/**
 * Created by Ashraf-XCODER on 3/18/2017.
 */
public class Person implements Serializable {

    public static final long serialVersionUID = 131231L;


    private int age;

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    private void writeObject(java.io.ObjectOutputStream ostream) throws IOException {
        ostream.writeInt(age - 10);
    }
    private void readObject(java.io.ObjectInputStream istream) throws IOException, ClassNotFoundException {
        age = istream.readInt() + 10;
    }
}
