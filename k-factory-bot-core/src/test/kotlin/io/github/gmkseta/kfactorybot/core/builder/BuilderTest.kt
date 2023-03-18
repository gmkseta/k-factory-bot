package io.github.gmkseta.kfactorybot.core.builder

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class BuilderTest {

    @Test
    fun create() {
        val builder = Builder(String::class)

        assertThrows(IllegalArgumentException::class.java) {
            builder.create()
        }

        builder.add("default") {
            "Hello"
        }

        assertEquals("Hello", builder.create())
    }

    @Test
    fun add() {
        val builder = Builder(String::class)

        builder.add("default") {
            "Hello"
        }

        assertEquals("Hello", builder.create())
    }


    @Test
    fun trait() {
        val builder = Builder(String::class)

        builder.add("default") {
            "Hello"
        }

        builder.trait("next") {
            "World"
        }

        assertEquals("Hello", builder.create())
        assertEquals("World", builder.create("next"))
        assertEquals("Hello", builder.create())

    }

    @Test
    fun reference(){
        val builder = Builder(String::class)

        builder.add("default") {
            "Hello"
        }

        builder.add("next") {
            "World"
        }

        val origin = builder.create()
        val next = builder.create("next")
        val origin2 = builder.create()

        assertNotEquals(origin, next)

        println(origin.hashCode())
        println(next.hashCode())
        println(origin2.hashCode())
    }
}