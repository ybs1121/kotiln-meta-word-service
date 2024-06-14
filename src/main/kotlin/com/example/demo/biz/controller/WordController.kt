package com.example.demo.biz.controller

import com.example.demo.biz.dto.WordDto
import com.example.demo.biz.service.WordService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/word")
class WordController constructor(private val wordService: WordService){

    @PostMapping
    fun saveWord(@RequestBody wordDto: WordDto): String {
        wordService.save(wordDto)
        return "OK"
    }

    @GetMapping("/all")
    fun getAllWords(): List<WordDto> {
        return wordService.findAll()
    }

}