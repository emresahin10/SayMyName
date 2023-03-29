package com.emresahin.saymyname.model

data class Character(
    val id: String,
    val name: String,
    val birthday: String,
    val nickname: String,
    val status: Boolean,
    val category: String,
    val img: String,
)