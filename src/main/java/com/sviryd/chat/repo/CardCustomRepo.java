package com.sviryd.chat.repo;

import com.sviryd.chat.domain.Card;

import java.util.List;

public interface CardCustomRepo {
    List<Card> findCardByWord(List<Card> cards);
}