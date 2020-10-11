package com.snailvoyager.springbooteatgo.interfaces;

import com.snailvoyager.springbooteatgo.application.RestaurantService;
import com.snailvoyager.springbooteatgo.domain.MenuItemRepository;
import com.snailvoyager.springbooteatgo.domain.MenuItemRepositoryImpl;
import com.snailvoyager.springbooteatgo.domain.RestaurantRepository;
import com.snailvoyager.springbooteatgo.domain.RestaurantRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RestaurantController.class)
class RestaurantControllerTest {
    @Autowired
    private MockMvc mvc;

    @SpyBean(RestaurantRepositoryImpl.class)    //Test에서 사용할 수 있도록 의존성 주입
    private RestaurantRepository restaurantRepository;

    @SpyBean(MenuItemRepositoryImpl.class)
    private MenuItemRepository menuItemRepository;

    @SpyBean(RestaurantService.class)
    private RestaurantService restaurantService;

    @Test
    public void list() throws Exception {
        mvc.perform(get("/restaurants"))
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("\"id\":1004")))
            .andExpect(content().string(containsString("\"name\":\"Bab zip\"")));
    }

    @Test
    public void detail() throws Exception {
        mvc.perform(get("/restaurants/1004"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"id\":1004")))
                .andExpect(content().string(containsString("\"name\":\"Bab zip\"")))
                .andExpect(content().string(containsString("Kimchi")));

        mvc.perform(get("/restaurants/2020"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"id\":2020")))
                .andExpect(content().string(containsString("\"name\":\"Cyber Food\"")));
    }

}