package com.company;

import java.io.*;
import java.awt.Window;

/**
 * Created by Ashraf-XCODER on 3/18/2017.
 */
public class Employee extends Person implements ObjectInputValidation {
    private String name;


    public Employee(int age, String name) {
        super(age);
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    private void writeObject(java.io.ObjectOutputStream ostream) throws IOException {
        ostream.writeUTF(name + "changed");
    }
    private void readObject(java.io.ObjectInputStream istream) throws IOException, ClassNotFoundException {
        istream.registerValidation(this, 0);
        name = istream.readUTF();
    }

    @Override
    public void validateObject() throws InvalidObjectException {
        if (name.contains("changed")){
            throw new InvalidObjectException("Object state is changed");
        }
    }
}
