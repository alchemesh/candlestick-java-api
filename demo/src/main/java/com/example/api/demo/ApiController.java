
package com.example.api.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;


// REST Controller
@RestController
@RequestMapping("/api")

public class ApiController {
    @Autowired
    private DayDAO dayDao;


    // GET endpoint
    @GetMapping("/{event_ID}")
    public Days getDays(@PathVariable String event_ID) {
        return dayDao.getAllDays(event_ID);
    }

    // POST endpoint
    @PostMapping("/")
    public ResponseEntity<Object> 
      addEvent(@RequestBody Stock stock) {
      
        //Event event = stock.getEvent();
        dayDao.setEvent(stock);

        
        // Build location URI
        URI location = ServletUriComponentsBuilder
          .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(stock)
                .toUri();

        return ResponseEntity.created(location).build();
        
    }
}
