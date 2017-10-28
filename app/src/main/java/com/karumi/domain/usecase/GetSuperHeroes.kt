package com.karumi.domain.usecase

import com.karumi.data.repository.SuperHeroRepository
import com.karumi.domain.model.DomainError
import com.karumi.domain.model.SuperHero
import org.funktionale.either.Either

class GetSuperHeroes(private val superHeroesRepository: SuperHeroRepository) {

    operator fun invoke(): Either<DomainError, List<SuperHero>> = superHeroesRepository
        .getAllSuperHeroes()
}