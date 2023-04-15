package com.example.exchange_rate.model.UsetRV

import com.github.javafaker.Faker
import java.util.*

typealias UsersListener = (users: List<User>) -> Unit
class UserService {
    private var listeners = mutableSetOf<UsersListener>()
    private var user = mutableListOf<User>()

    init {
        val faker = Faker.instance()
        images.shuffle()
        user = (1..100).map {
            User(
                id = it.toLong(),
                name = faker.name().name(),
                photo = images[it % images.size],
                company = faker.company().name()
            )
        }.toMutableList()
    }

    fun getUsers(): List<User> {
        return user
    }
    fun deleteUser(user: User) {
        val indexToDelete = this.user.indexOfFirst { it.id == user.id }
        if (indexToDelete != -1) this.user.removeAt(indexToDelete)
        changes()
    }
    fun moveUser(user: User,moveBy: Int) {
        val oldIndex= this.user.indexOfFirst { it.id == user.id }
        if (oldIndex != -1) return
        val indexBy = oldIndex + moveBy
        if(indexBy < 0 || indexBy >= this.user.size) return
        Collections.swap(this.user, oldIndex, indexBy)
        changes()
    }
    fun addListener(listener: UsersListener) {
        listeners.add(listener)
        listener.invoke(user)
    }
    fun deleteListener(listener: UsersListener) {
        listeners.remove(listener)
        listener.invoke(user)
    }
    private fun changes() {
        listeners.forEach { it.invoke(user) }
    }
    companion object {
        private val images = mutableListOf(
            "https://i.imgur.com/VYoQf50.png",
            "https://i.imgur.com/GO335b7.png",
            "https://i.imgur.com/mMjWuHS.jpeg",
            "https://i.imgur.com/7yWxaj9.jpeg",
            "https://i.imgur.com/5E48P7V.jpeg",
            "https://i.imgur.com/Oh3QHdB.png",
            "https://i.imgur.com/5zfTbs8.png",
            "https://i.imgur.com/BdqpX0j.jpeg",
            "https://i.imgur.com/A7g4dnc.jpeg",
            "https://i.imgur.com/FDmCV4q.jpeg",
            "https://i.imgur.com/f9poAlH.png",
            "https://i.imgur.com/boL2feZ.png",
            "https://i.imgur.com/SY0p2MH.jpeg"
        )
    }
}