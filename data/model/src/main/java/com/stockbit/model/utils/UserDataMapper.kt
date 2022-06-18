package com.stockbit.model.utils

import com.stockbit.model.domain.User
import com.stockbit.model.local.UserEntity

object UserDataMapper {
    fun mapDomainToEntity(input: User) : UserEntity {
        return UserEntity(input.id, input.name)
    }
}