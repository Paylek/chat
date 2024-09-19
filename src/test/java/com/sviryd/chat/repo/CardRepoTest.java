package com.sviryd.chat.repo;


import com.sviryd.chat.domain.Card;
import com.sviryd.chat.domain.User;
import com.sviryd.chat.domain.resource.UserResource;
import com.sviryd.chat.domain.type.Gender;
import com.sviryd.chat.domain.type.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;

@DataJpaTest
@ActiveProfiles("test")
public class CardRepoTest {
    private static final UserResource USER_CREDENTIAL = new UserResource("admin", "password");
    private Card card;
    @Autowired
    private CardRepo cardRepo;

    @BeforeEach
    public void init() {
        card = cardRepo.save(getCard());
    }

    @Test
    public void findByWordIn() {
        assertEquals(card.getWord(), "apple");
    }

    private Card getCard() {
        User user = new User();
        user.setUsername(USER_CREDENTIAL.getUsername());
        user.setGender(Gender.M);
        user.setRoles(new HashSet<>(Arrays.asList(Role.ADMIN, Role.USER)));
        Card card1 = new Card();
        card1.setWord("apple");
        card1.setTranslation("pen");
        card1.setAuthor(user);
        return card1;
    }
}
