package com.emresahin.saymyname.network.model

import com.emresahin.saymyname.model.Character
import kotlinx.serialization.Serializable

@Serializable
data class NetworkCharacter(
    val charId: String? = null,
    val name: String? = null,
    val birthday: String? = null,
    val img: String? = null,
    val status: String? = null,
    val nickname: String? = null,
    val portrayed: String? = null,
    val category: String? = null,
)

fun NetworkCharacter.asExternal(): Character = Character(
    charId = charId.orEmpty(),
    name = name.orEmpty(),
    birthday = birthday.orEmpty(),
    img = img.orEmpty(),
    status = status.orEmpty(),
    nickname = nickname.orEmpty(),
    portrayed = portrayed.orEmpty(),
    category = category.orEmpty(),
)