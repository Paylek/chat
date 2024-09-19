package com.sviryd.chat.service;

import com.sviryd.chat.domain.Card;
import com.sviryd.chat.domain.Message;
import com.sviryd.chat.repo.CardRepo;
import com.sviryd.chat.repo.MessageRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CardService {
    private final CardRepo cardRepo;

    public CardService(final CardRepo cardRepo) {
        this.cardRepo = cardRepo;
    }

    public Page<Card> getPage(Pageable pageable) {
        return cardRepo.findAll(pageable);
    }

    public Card save(Card card) {
        return cardRepo.save(card);
    }
}
