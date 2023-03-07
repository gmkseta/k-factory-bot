# Kotlin FactoryBot Library

Kotlin FactoryBot is a library that allows you to easily define instances of any class for use in your tests.

## Features

- Define instances of any class with a single function call.
- Easily create instances of a defined class with a specified type.
- Support for default and custom instance types.
- Easily add traits to existing instances to modify their properties.

## Installation

Add the following dependency to your Gradle file:

```groovy
dependencies {
    implementation 'io.github.gmkseta:kfactorybot:0.0.1'
}
```

## Usage

To define an instance of a class, use the `define` function. You can specify the class to define and a lambda that will be used to define the instance. For example:

```kotlin
// Define a User class
data class User(val name: String, val email: String)

// Define a FactoryBot instance for the User class
val userFactory = FactoryBot.define(User::class) {
    add("default") {
        User(
            name = "Alice",
            email = "alice@test.com"
        )
    }
    trait("invalidEmail") {
        copy(email = "a")
    }
}
```

This code defines a `User` class with two properties: `name` and `email`. Then we define a `userFactory` FactoryBot instance for the `User` class with a default instance and an `invalidEmail` trait that modifies the `email` property of the instance to an invalid value.

To create an instance of a defined class, use the `create` function. You can specify the class to create and the type of instance to create (if you have defined multiple types). For example:

```kotlin
// Create a user instance with the default type
val user = userFactory.create()

// Create an invalid user instance with the "invalidEmail" type
val invalidUser = userFactory.create("invalidEmail")
```

This code creates a `user` instance using the default type and an `invalidUser` instance using the `invalidEmail` type, both of which were defined earlier.

To modify an existing instance, use the `trait` function. You can specify the instance to modify and a lambda that will modify its properties. For example:

```kotlin
// Modify the "invalidEmail" instance to have a valid email address
userFactory.trait(invalidUser, "invalidEmail") {
    copy(email = "invalid@test.com")
}
```

This code modifies the `invalidUser` instance created earlier to have a valid email address.

### Full code

```kotlin
// Define a User class
data class User(val name: String, val email: String)

// Define a FactoryBot instance for the User class
val userFactory = FactoryBot.define(User::class) {
    add("default") {
        User(
            name = "Alice",
            email = "alice@test.com"
        )
    }
    trait("invalidEmail") {
        copy(email = "a")
    }
}

// Create a user instance with the default type
val user = userFactory.create()

// Create an invalid user instance with the "invalidEmail" type
val invalidUser = userFactory.create("invalidEmail")

// Modify the "invalidEmail" instance to have a valid email address
userFactory.trait(invalidUser, "invalidEmail") {
    copy(email = "invalid@test.com")
}
```

## License

This library is released under the MIT License. See `LICENSE` for more information.
