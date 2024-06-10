package com.example.demo.biz.entity

import com.example.demo.biz.dto.WordDto
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import lombok.Getter

@Getter
@Entity
class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    var word: String = "null"

    @Column(unique = true)
    var abbreviation: String = "null"


    //static 개념이랑 비슷
    companion object {
        fun toEntity(wordDto: WordDto): Word {
            val word = Word()
            word.word = wordDto.word
            word.abbreviation = wordDto.abbreviation
            return word
        }
    }


}