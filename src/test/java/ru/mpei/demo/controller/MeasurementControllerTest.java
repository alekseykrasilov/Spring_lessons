package ru.mpei.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.mpei.demo.model.Measurement;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MeasurementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * переводит из JSON в String и обратно
     */

    @Test
    public void getById() throws Exception {

        Measurement expected = new Measurement(12, 12, 12, 22, 22, 22);
        expected.setId(2);

        mockMvc.perform(get("/measurement/get?id=2"))
                .andDo(print())
                .andExpect(content().string(objectMapper.writeValueAsString(expected)))
                .andExpect(status().is(200));
    }

    @Test
    public void save() throws Exception {

        Measurement expected = new Measurement(12, 12, 12, 22, 22, 22);

        mockMvc.perform(post("/measurement/add?equipmentId=1")
                        .content(objectMapper.writeValueAsString(expected))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200));
    }
}