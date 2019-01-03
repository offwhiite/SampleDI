package c.offwhite.novel.di

import c.offwhite.novel.domain.ISearchRepository
import c.offwhite.novel.infra.INarouNovelAPI
import c.offwhite.novel.infra.NarouRepository
import dagger.Component

@Component(modules = [RepositoryModule::class])
interface RepositoryComponent {
    fun inject() : ISearchRepository
}