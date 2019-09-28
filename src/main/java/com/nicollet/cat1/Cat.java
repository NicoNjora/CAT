package com.nicollet.cat1;

import com.nicollet.cat1.models.BlindDate;
import com.nicollet.cat1.models.ReasonDTO;
import com.nicollet.cat1.models.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Cat implements CommandLineRunner {

    private final FeignRestClient feignRestClient;

    public Cat(FeignRestClient feignRestClient) {
        this.feignRestClient = feignRestClient;
    }

    @Override
    public void run(String... args) throws Exception {
        Student student = feignRestClient.create(new Student("90456","Nicollet"));

        System.out.println("Voila: " + feignRestClient.findById(student.getStudentNumber()));

        System.out.println(feignRestClient.findMatch("FEMALE", student.getId()));

        System.out.println(feignRestClient.rejectDate(44L, new ReasonDTO(student.getId(), "I am female I cannot date a female")));
//
//        System.out.println(feignRestClient.getDate());

//
        System.out.println("Voila: " + feignRestClient.chooseDate(44L, 19L, student.getId()));


    }
}
