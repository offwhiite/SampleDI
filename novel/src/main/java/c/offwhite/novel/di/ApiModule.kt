package c.offwhite.novel.di

import c.offwhite.novel.external.api.INarouOpenApi
import c.offwhite.novel.external.api.NarouOpenApi
import dagger.Module
import dagger.Provides

@Module
class ApiModule {
    @Provides
    fun provideNarouApi(narouOpenApi: NarouOpenApi): INarouOpenApi {
        return narouOpenApi
    }
}