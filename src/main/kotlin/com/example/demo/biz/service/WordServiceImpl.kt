package com.example.demo.biz.service

import com.example.demo.biz.repository.WordRepository
import com.example.demo.biz.dto.WordDto
import com.example.demo.biz.entity.Word
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DuplicateKeyException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.stream.Collectors

@Transactional
@Service
class WordServiceImpl : WordService {

    @Autowired
    lateinit var wordRepository: WordRepository

    override fun save(wordDto: WordDto): Long {
        var word = Word.toEntity(wordDto)
        if(wordRepository.isExist(word)) {
            throw DuplicateKeyException("이미 약어가 존재합니다.")
        }
        wordRepository.insert(word)
        return word.id
    }

    override fun findAll(): List<WordDto> {
        return wordRepository.findAll()
            .stream()
            .map { word -> WordDto(word = word.word, abbreviation = word.abbreviation) }
            .collect(Collectors.toList())
    }
}