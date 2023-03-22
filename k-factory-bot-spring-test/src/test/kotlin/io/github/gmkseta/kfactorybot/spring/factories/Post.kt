package io.github.gmkseta.kfactorybot.spring.factories

import javax.persistence.*

@Entity
data class Post(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    var id: Long? = null,
    var title: String,
    var content: String
)