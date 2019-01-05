package c.offwhite.novel.di

import c.offwhite.novel.domain.IGetPageRepository
import c.offwhite.novel.domain.ISearchRepository
import dagger.Component

@Component(modules = [RepositoryModule::class, ApiModule::class])
interface RepositoryComponent {
    fun inject(): ISearchRepository
}