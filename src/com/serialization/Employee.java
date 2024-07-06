package com.serialization;

//Serialization is the conversion of a Java object into  a static stream (sequence) of bytes,
// which we can then save to a database or transfer over a network.
//Classes that are eligible for serialization need to implement a special marker interface, Serializable.
// The JVM allows special privileges to the class which implements the Serializable Interface.
//Byte stream is platform-independent. This means that once you have a stream of bytes
// you can convert it into an object and run it on any kind of environment.
//A class to be serialized successfully, two conditions must be met −
    //1)The class must implement the java.io.Serializable interface.
    //2)all fields in the class must be serializable. If a field is not serializable, it must be marked transient.
//static fields belong to a class (as opposed to an object) and are not serialized
//fields which are marked as transient JVM will not convert those fields into byte stream. eg:- private transient String name;

import java.io.*;

public class Employee implements Serializable {
    private String id;
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Employee emp=new Employee();
        emp.setId("1");
        emp.setName("ramesh");
        FileOutputStream fileOutputStream=new FileOutputStream("C:\\Users\\Ramesh Dornala\\Desktop\\LEARNING PROJECTS\\advJAVAConcepts\\employee.ser");
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(emp);
        objectOutputStream.close();
        fileOutputStream.close();
        //Deserialization
        FileInputStream inputStream=new FileInputStream("C:\\Users\\Ramesh Dornala\\Desktop\\LEARNING PROJECTS\\advJAVAConcepts\\employee.ser");
        ObjectInputStream objectInputStream=new ObjectInputStream(inputStream);
        Employee e=(Employee) objectInputStream.readObject();
    }
}


//externalization in Java is used whenever you need to customize the serialization mechanism.
//
//In serialization, the Java Virtual Machine is totally responsible for the process of writing and reading objects.
// This is useful in most cases, as the programmers do not have to care about the underlying details of the serialization process.
// However, the default serialization does not protect sensitive information such as passwords and credentials,
// or what if the programmers want to secure some information during the serialization process?
//
//externalization comes to give the programmers full control in reading and writing objects during serialization.
// JVM has no control over it. The complete serialization control goes to the application.
//
//Based on our requirements, we can serialize either the whole data field or a piece of the data field using the
// externalizable interface which can help to improve the performance of the application.
//
//Externalizable interface internaly extends Serializable interface
//
//Externalizable interface is not a marker interface like Serializable interface. So, it provides two methods that are as follows:
//
//void readExternal(ObjectInput inStream) - we call readExternal() method when we want to read an object’s fields
// from a stream. We need to write logic to read an object’s fields inside the readExternal() method. The readExternal() method throws IOException
// when an I/O error occurs. If the class of object being restored does not find, ClassNotException will be thrown.
//
//void writeExternal(ObjectOutput outStream):  writeExternal() method is used when we want
// to write an object’s fields to a stream. We need to write the logic to write data fields inside writeExternal() method.
// This method can throw an IOException when an I/O error occurs.
