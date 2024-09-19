package com.sviryd.chat.repo.impl;

import com.sviryd.chat.domain.Card;
import com.sviryd.chat.repo.CardCustomRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;

public class CardCustomRepoImpl implements CardCustomRepo {

    private final EntityManager entityManager;

    public CardCustomRepoImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();

    }

    @Override
    public List<Card> findCardByWord(List<Card> cards) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Card> cq = cb.createQuery(Card.class);
        Root<Card> root = cq.from(Card.class);
        List<Predicate> predicatesOR = new ArrayList<>();
        for (int i = 0; i < cards.size(); i++) {
            Predicate word = cb.equal(root.get("word"), cards.get(i).getWord());
            Predicate or = cb.and(word);
            predicatesOR.add(or);
        }
        Predicate or = cb.or(predicatesOR.toArray(new Predicate[predicatesOR.size()]));
        cq.select(root).where(or).distinct(true);
        TypedQuery<Card> query = entityManager.createQuery(cq);
        return query.getResultList();
    }
}