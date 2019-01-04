package c.offwhite.novel.di

import c.offwhite.novel.domain.WebSite
import dagger.BindsInstance
import dagger.Component

@Component(modules = [RepositoryModule::class, ApiModule::class])
interface DomainComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun domain(domain: String): Builder
        fun build(): DomainComponent
    }

    fun inject() : WebSite
}