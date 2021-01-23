package com.galvanize.guestbook.repository;

import com.galvanize.guestbook.model.Guest;
import org.aspectj.lang.annotation.control.CodeGenerationHint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private GuestRepository guestRepository;

    @Autowired
    public DataLoader(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }



    @Override
    public void run(ApplicationArguments args) throws Exception {
        guestRepository.save(new Guest("amal","hello"));
        guestRepository.save(new Guest("naga","Hi Guests"));
        guestRepository.save(new Guest("vijaya","this is another comment"));

    }
}
