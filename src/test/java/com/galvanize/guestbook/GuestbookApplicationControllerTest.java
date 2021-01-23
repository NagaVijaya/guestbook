package com.galvanize.guestbook;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.guestbook.model.Guest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@SpringBootTest
class GuestbookApplicationControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	public Guest initGuest(){
		Guest guest = new Guest("amal","hello");
		return guest;
	}

	@Test
	public void addGuestNameAndComment() throws Exception {
		mockMvc.perform(post("/api/guestComment")
				.content(objectMapper.writeValueAsString(initGuest()))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	}

	@Test
	public void getGuestBookComments() throws Exception {
		mockMvc.perform(post("/api/guestComment")
				.content(objectMapper.writeValueAsString(initGuest()))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());

		mockMvc.perform(get("/api/guestComments"))
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(jsonPath("length()").value(1))
				.andExpect(jsonPath("$[0].id").exists())
				.andExpect(jsonPath("$[0].name").value("amal"))
				.andExpect(jsonPath("$[0].comment").value("hello"));
	}

}
