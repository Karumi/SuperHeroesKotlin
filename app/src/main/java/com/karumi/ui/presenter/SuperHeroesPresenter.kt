package com.karumi.ui.presenter

import co.metalab.asyncawait.async
import com.karumi.common.weak
import com.karumi.domain.model.DomainError
import com.karumi.domain.model.SuperHero
import com.karumi.domain.usecase.GetSuperHeroes
import com.karumi.ui.LifecycleSubscriber
import org.funktionale.either.Either.Left
import org.funktionale.either.Either.Right

class SuperHeroesPresenter(
    view: View,
    private val getSuperHeroes: GetSuperHeroes) : LifecycleSubscriber {

    private val view: View? by weak(view)

    override fun update() {
        view?.showLoading()
        refreshSuperHeroes()
    }

    private fun refreshSuperHeroes() = async {
        val result = await { getSuperHeroes() }
        view?.hideLoading()
        when (result) {
            is Right -> showSuperHeroes(result.r)
            is Left -> view?.showError(result.l)
        }
    }

    private fun showSuperHeroes(result: List<SuperHero>) {
        when {
            result.isEmpty() -> view?.showEmptyCase()
            else -> view?.showSuperHeroes(result)
        }
    }

    fun onSuperHeroClicked(superHero: SuperHero) = view?.openDetail(superHero.name)

    interface View {
        fun hideLoading()
        fun showSuperHeroes(superHeroes: List<SuperHero>)
        fun showLoading()
        fun showEmptyCase()
        fun openDetail(name: String)
        fun showError(l: DomainError)
    }
}