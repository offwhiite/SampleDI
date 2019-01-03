package c.offwhite.novel.di

import c.offwhite.novel.external.api.INarouOpenApi
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {
    fun inject(): INarouOpenApi
}