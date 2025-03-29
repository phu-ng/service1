package com.example.micro1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

@RestController
public class Hello {
    @GetMapping("/")
    public String getHello() {
        return "Hello";
    }

    public void insecureCode() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.ser"))) {
            Object obj = ois.readObject(); // Vulnerable to deserialization attacks
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
