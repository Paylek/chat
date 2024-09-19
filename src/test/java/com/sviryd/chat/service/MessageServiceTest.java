package com.sviryd.chat.service;

import com.sviryd.chat.domain.Message;
import com.sviryd.chat.domain.User;
import com.sviryd.chat.domain.resource.UserResource;
import com.sviryd.chat.domain.type.Gender;
import com.sviryd.chat.domain.type.Role;
import com.sviryd.chat.repo.MessageRepo;
import com.sviryd.chat.repo.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = {UserService.class})
@ActiveProfiles("test")
public class MessageServiceTest {

    private static final UserResource USER_CREDENTIAL = new UserResource("admin", "password");
    @Autowired
    private MessageService messageService;
    @MockBean
    private MessageRepo messageRepo;

    private Message message;

    @BeforeEach
    public void init() {
        message = messageService.save(getMessage());
    }

    @Test
    public void testSaveMessage() {
        User user = new User();
        user.setUsername(USER_CREDENTIAL.getUsername());
        user.setGender(Gender.M);
        user.setRoles(new HashSet<>(Arrays.asList(Role.ADMIN, Role.USER)));
        Message message1;
        message1 = Message.builder().author(user).text("milk").build();
        Mockito.when(messageRepo.findByAuthor(message1.getAuthor()));

        Optional<Message> result = messageService.findByAuthor(message1.getAuthor());
        assertNotNull(result.orElse(null));
        assertEquals(user.getId(), result.get().getId());
    }

    private Message getMessage() {
        User user = new User();
        user.setUsername(USER_CREDENTIAL.getUsername());
        user.setGender(Gender.M);
        user.setRoles(new HashSet<>(Arrays.asList(Role.ADMIN, Role.USER)));
        Message message1 = new Message();
        message1 = Message.builder().author(user).text("milk").build();
        return message1;
    }
}
