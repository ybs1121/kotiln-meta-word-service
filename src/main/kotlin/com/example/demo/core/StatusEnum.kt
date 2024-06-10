package com.example.demo.core

enum class StatusEnum(
    val code: String,
    val message: String,
) {

    OK("OK", "정상적으로 처리되었습니다."),
    SERVER_ERROR("SERVER_ERROR", "서버에서 오류가 발생했습니다.")
}