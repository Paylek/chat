package com.sviryd.chat.repo;

import com.sviryd.chat.domain.Card;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CardRepo extends JpaRepository<Card, Long> , PagingAndSortingRepository<Card, Long>  {

    Page<Card> findAll(Pageable pageable);

    List<Card> findByWordIn(List<String> words);

    @Query("select d from Card d where d.author.id in :ids")
    List<Card> getCardsByAuthorId (List<Long> ids);

    @Modifying
    @Query("update Card c set c.word = :word, c.translation = :translation where c.id = :id")
    int updateWordAndTranslationById(Long id, String word, String translation);

}
