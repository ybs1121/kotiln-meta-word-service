package com.example.demo.biz.service

import com.example.demo.biz.dto.WordDto

interface WordService {

    fun save(wordDto: WordDto):Long

    fun findAll(): List<WordDto>
}