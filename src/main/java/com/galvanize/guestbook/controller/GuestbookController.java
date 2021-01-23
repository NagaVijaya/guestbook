package com.galvanize.guestbook.controller;


import com.galvanize.guestbook.model.Guest;
import com.galvanize.guestbook.service.GuestService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GuestbookController {

    GuestService guestService;

    public GuestbookController(GuestService guestService){
        this.guestService = guestService;
    }

    @GetMapping("/home")
    public String greeting(){
        return "Welcome to GuestBook!!!";
    }

    @PostMapping("/api/guestComment")
    @ResponseStatus(HttpStatus.CREATED)
    public void addGuestNameAndComment(@RequestBody Guest guest){
        guestService.addGuestNameAndComment(guest);
    }

    @GetMapping("/api/guestComments")
    public List<Guest> getGuestBookEntries(){
        return guestService.getGuestBookEntries();
    }

}
