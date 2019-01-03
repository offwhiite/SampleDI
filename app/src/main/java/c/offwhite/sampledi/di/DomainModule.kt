package c.offwhite.sampledi.di

import c.offwhite.novel.domain.ISearchRepository
import c.offwhite.novel.infra.NarouRepository
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provieNovelRepository(narouRepository: NarouRepository): ISearchRepository {
        return narouRepository
    }
}