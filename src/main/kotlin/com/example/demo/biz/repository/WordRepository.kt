package com.example.demo.biz.repository

import com.example.demo.biz.entity.Word
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Repository

@Repository
class WordRepository(
    private val em: EntityManager
) {

    fun insert(word: Word): Long {
        em.persist(word)
        return word.id
    }

    fun findAll(): List<Word> {
        val resultList = em.createQuery(
            "SELECT w FROM Word w ORDER BY id DESC",
            Word::class.java
        ).resultList

        return resultList
    }

    fun isExist(word: Word): Boolean {
        return em.createQuery("" +
                "select exists (select 1 FROM Word w WHERE w.abbreviation =: abbreviation )", Boolean::class.java)
            .setParameter("abbreviation", word.abbreviation)
            .singleResult
    }
}