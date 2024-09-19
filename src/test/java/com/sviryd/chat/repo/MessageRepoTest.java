package com.sviryd.chat.repo;

import com.sviryd.chat.domain.Card;
import com.sviryd.chat.domain.Message;
import com.sviryd.chat.domain.User;
import com.sviryd.chat.domain.resource.UserResource;
import com.sviryd.chat.domain.type.Gender;
import com.sviryd.chat.domain.type.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ActiveProfiles("test")
public class MessageRepoTest {
    private static final UserResource USER_CREDENTIAL = new UserResource("admin", "password");
    private Message message;
    @Autowired
    private MessageRepo messageRepo;

    @BeforeEach
    public void init() {
        message = messageRepo.save(getMessage());
    }


    @Test
    public void findByWordIn() {
        assertEquals(message.getText(), "milk");
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
