package com.stockbit.hiring.usecase

import com.stockbit.model.domain.User
import com.stockbit.repository.UserRepository

interface UserUseCase {
    fun login(user: User)
}

class UserUseCaseImpl(private val userRepository: UserRepository): UserUseCase {
    override fun login(user: User) {
        userRepository.login(user)
    }

}