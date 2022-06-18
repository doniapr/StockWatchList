package com.stockbit.repository

import com.stockbit.local.dao.UserDao
import com.stockbit.model.domain.User
import com.stockbit.model.utils.UserDataMapper
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

interface UserRepository {
    fun login(user: User)
}

class UserRepositoryImpl(private val dao: UserDao) : UserRepository {
    override fun login(user: User) {
        GlobalScope.launch {
            dao.save(UserDataMapper.mapDomainToEntity(user))
        }
    }

}