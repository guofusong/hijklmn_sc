package edu.guosong.sc.hijklmnadmin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import edu.guosong.sc.hijklmncommon.dto.UserDTO;
import edu.guosong.sc.hijklmncommon.param.RequestUrlOption;


public class ApplicationTest {

	public static void main(String[] args) {
		RestTemplate template = new RestTemplate();

		UserDTO userDTO = new UserDTO();

		userDTO.setUsername("guofusong");
		userDTO.setPassword("123456");

		Map<String, String> map = new HashMap<>();
		map.put("username", "guofusong");
		map.put("password", "123456");

		//template.postForEntity("http://127.0.0.1:8080/" + RequestUrlOption.DB_USER_LOGIN, userDTO, RequestResult.class);

	}

}
