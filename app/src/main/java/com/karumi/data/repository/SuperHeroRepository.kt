package com.karumi.data.repository

import com.karumi.domain.model.DomainError
import com.karumi.domain.model.SuperHero
import org.funktionale.either.Either

class SuperHeroRepository(private val datasources: List<SuperHeroDataSource>) {

    fun getAllSuperHeroes(): Either<DomainError, List<SuperHero>> {
        val values = datasources.first { it.isUpdated() }.getAll()
        values.component2()?.let { list -> datasources.forEach { it.populate(list) } }
        return values
    }

    fun getByName(key: String): Either<DomainError, SuperHero> =
        datasources.first { it.isUpdated() && it.contains(key) }.get(key)

}