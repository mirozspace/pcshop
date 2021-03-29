package shop.web;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import shop.ShopApplication;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = ShopApplication.class)
public class AboutControllerTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void index_returnsCorrectValue() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.get("/"))
			.andExpect(view().name("home"));
	}

	/*
	 * @Test
	 * 
	 * @WithMockUser("spring") public void home_returnsCorrectValue() throws
	 * Exception {
	 * this.mvc.perform(MockMvcRequestBuilders.get("/home")).andExpect(view().name(
	 * "home"));
	 * 
	 * }
	 */
}
