package com.karumi.domain.usecase

import com.karumi.data.repository.SuperHeroRepository
import com.karumi.domain.model.DomainError
import com.karumi.domain.model.SuperHero
import org.funktionale.either.Either

class GetSuperHeroByName(private val superHeroesRepository: SuperHeroRepository) {

    operator fun invoke(name: String): Either<DomainError, SuperHero> = superHeroesRepository
        .getByName(name)
}