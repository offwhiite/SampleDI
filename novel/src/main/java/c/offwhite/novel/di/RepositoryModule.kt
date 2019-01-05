package c.offwhite.novel.di

import c.offwhite.novel.domain.IGetPageRepository
import c.offwhite.novel.domain.ISearchRepository
import c.offwhite.novel.external.api.INarouOpenApi
import c.offwhite.novel.external.api.NarouOpenApi
import c.offwhite.novel.infra.NarouHtmlRepository
import c.offwhite.novel.infra.NarouRepository
import c.offwhite.novel.infra.api.INarouPageApi
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideNarouRepository(narouApi: INarouOpenApi): ISearchRepository {
        return NarouRepository(narouApi)
    }

    @Provides
    fun provideNarouPageRepository(narouApi: INarouPageApi): IGetPageRepository {
        return NarouHtmlRepository(narouApi)
    }
}