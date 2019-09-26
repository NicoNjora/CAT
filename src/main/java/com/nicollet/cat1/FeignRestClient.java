package com.nicollet.cat1;

import com.nicollet.cat1.models.ReasonDTO;
import com.nicollet.cat1.models.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "client", url = "http://10.51.10.111:2200", configuration = FeignConfig.class)
public interface FeignRestClient {

    @RequestMapping(method = RequestMethod.POST, value = "students")
    Student create(@RequestBody Student student);

    @RequestMapping(method = RequestMethod.GET, value="students")
    Student findById(@RequestParam(name = "studentNumber") String studentNumber);

    @RequestMapping(method = RequestMethod.POST, value="matches")
    Student findMatch(@RequestParam(name = "gender") String gender,
                      @RequestParam(name= "studentId") Long studentId);

    @RequestMapping(method = RequestMethod.PATCH, value="matches/{id}")
    ReasonDTO rejectDate(@PathVariable(name = "id") Long id,
                         @RequestBody ReasonDTO reason);

    @RequestMapping(method = RequestMethod.GET, value="matches")
    Student getDate();

    @RequestMapping(method = RequestMethod.PUT, value="dates/{id}")
    Student chooseDate(@PathVariable(name = "id") Long id,
                @RequestParam(name= "matchId") Long matchId,
                @RequestParam(name= "studentId") Long studentId);
}