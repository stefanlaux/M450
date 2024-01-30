package ch.tbz.recipe.planner.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class RecipeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getRecipes() throws Exception {
        this.mockMvc.perform(get("/api/recipes")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }
    @Test
    void getRecipe() throws Exception {
        this.mockMvc.perform(get("/api/recipes/recipe/2e33bd74-eff1-4539-b97e-5679cf5fb41a"))
                .andExpect(status().isOk());
    }

    @Test
    void addRecipe() throws Exception {
        this.mockMvc.perform(post("/api/recipes")
                .contentType("application/json")
                .content("{\"id\": \"c558a80a-f319-4c10-95d4-4282ef745b4b\", \"name\": \"testing\", \"imageUrl\": \"https://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/Cat03.jpg/1200px-Cat03.jpg\"}"
                ))
                .andExpect(status().isOk());

    }
}