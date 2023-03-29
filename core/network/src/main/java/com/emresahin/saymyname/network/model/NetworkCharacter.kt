package com.emresahin.saymyname.network.model

import com.emresahin.saymyname.model.Character
import kotlinx.serialization.Serializable

@Serializable
data class NetworkCharacter(
    val id: String? = null,
    val name: String? = null,
    val birthday: String? = null,
    val nickname: String? = null,
    val status: Boolean? = null,
    val category: String? = null,
    val img: String? = null,
)

fun NetworkCharacter.asExternal(): Character = Character(
    id = id.orEmpty(),
    name = name.orEmpty(),
    birthday = birthday.orEmpty(),
    nickname = nickname.orEmpty(),
    status = status ?: false,
    category = category.orEmpty(),
    img = img.orEmpty()
)