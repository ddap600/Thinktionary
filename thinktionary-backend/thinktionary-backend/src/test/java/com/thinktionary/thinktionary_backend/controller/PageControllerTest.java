package com.thinktionary.thinktionary_backend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // TODO: Create test page in test database and capture generated ID.
    // TODO: Use generated ID instead of hardcoding "/page/1".
    // TODO: Configure isolated test database so tests don't use ThinktionaryDB.

    @Test
    void createPage() throws Exception {
        mockMvc.perform(
                        post("/page")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("""
                                        {
                                            "title": "Cats",
                                            "content": "Cats are content."
                                        }
                                        """)

                )
                .andExpect(status().isOk());
    }

    @Test
    void getAllPages() throws Exception {
        mockMvc.perform(
                        get("/page")
                )
                .andExpect(status().isOk());
    }

    @Test
    void getPageById() throws Exception {

        // TODO: Create test page and get its generated ID

        /*
        mockMvc.perform(
                        get("/page/{id}", pageId)
                )
                .andExpect(status().isOk());

         */
    }


    @Test
    void updatePage() throws Exception {

        // TODO: Create test page and get its generated ID

        /*
        mockMvc.perform(
                        put("/page/{id}", pageId)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("""
                                        {
                                            "title": "Cats",
                                            "content": "Cats are updated."
                                        }
                                        """)
                )
                .andExpect(status().isOk());
         */
    }

    @Test
    void deletePage() throws Exception {

        // TODO: Create test page and get its generated ID

        /*
        mockMvc.perform(
                        delete("/page/{id}", pageId)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("""
                                        {
                                            "title": "Cats",
                                            "content": "Cats are updated."
                                        }
                                        """)
                )
                .andExpect(status().isOk());

         */
    }
}
