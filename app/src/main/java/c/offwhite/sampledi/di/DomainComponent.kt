package c.offwhite.sampledi.di

import c.offwhite.novel.domain.WebSite
import dagger.Component

@Component(modules = [DomainModule::class])
interface DomainComponent {
    fun inject(webSite: WebSite)
}