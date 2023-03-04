package kr.gmkseta.kfactorybot.factory

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class FactoryTest{

    internal data class User(
        val name: String,
        val email: String
    )

    private val userFactory = Factory.define(User::class) {
        add("default") {
            User(
                name = "Alice",
                email = "alice@test.com"
            )
        }
    }


    @Test
    fun `FactoryBot can create a factory`(){
        val user = userFactory.create()
        assertEquals("Alice", user.name)
        assertEquals("alice@test.com", user.email)

    }

    @Test
    fun `FactoryBot can create a factory with trait`() {
        userFactory.trait("next") {
            copy(name = "Bob")
        }
        val user = userFactory.create("next")
        assertEquals("Bob", user.name)
        assertEquals("alice@test.com", user.email)
    }

}