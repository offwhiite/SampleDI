package c.offwhite.novel.di

import c.offwhite.novel.domain.ISearchRepository
import c.offwhite.novel.external.api.INarouOpenApi
import c.offwhite.novel.infra.NarouRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideNarouRepository(narouApi: INarouOpenApi): ISearchRepository {
        return NarouRepository(narouApi)
    }
}