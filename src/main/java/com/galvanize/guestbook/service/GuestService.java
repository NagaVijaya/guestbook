package com.galvanize.guestbook.service;


import com.galvanize.guestbook.model.Guest;
import com.galvanize.guestbook.repository.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {

    GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository){
        this.guestRepository = guestRepository;
    }

    public void addGuestNameAndComment(Guest guest){
        guestRepository.save(guest);
    }

    public List<Guest> getGuestBookEntries()
    {
        return guestRepository.findAll();
    }

}
