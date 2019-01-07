package c.offwhite.novel.di

import c.offwhite.novel.infra.api.INarouOpenApi
import c.offwhite.novel.infra.api.INarouPageApi
import c.offwhite.novel.infra.api.NarouOpenApi
import c.offwhite.novel.infra.api.NarouPageApi
import dagger.Module
import dagger.Provides

@Module
class ApiModule {
    @Provides
    fun provideNarouApi(narouOpenApi: NarouOpenApi): INarouOpenApi {
        return narouOpenApi
    }

    @Provides
    fun provideNarouPageApi(narouPageApi: NarouPageApi): INarouPageApi {
        return narouPageApi
    }
}