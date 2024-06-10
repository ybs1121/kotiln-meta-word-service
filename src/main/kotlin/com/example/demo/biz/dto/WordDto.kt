package com.example.demo.biz.dto

import com.example.demo.biz.entity.Word


data class WordDto(var word: String, var abbreviation: String) {

    init {
        if (word == null) {
            throw NullPointerException("word is null")
        }

        if (abbreviation == null)
            throw NullPointerException("abbreviation is null")

        this.word = word
        this.abbreviation = abbreviation
    }



    //static 개념이랑 비슷
    companion object {
        fun toDto(word : Word) : WordDto {
            var wordDto = WordDto(word = word.word, abbreviation = word.abbreviation)
            return wordDto
        }
    }

}