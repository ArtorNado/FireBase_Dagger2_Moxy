package com.homework.fbmxdg.service.di

import com.homework.fbmxdg.app.scope.ApplicationScope
import com.homework.fbmxdg.service.email.EmailService
import com.homework.fbmxdg.service.email.EmailServiceImpl
import dagger.Module
import dagger.Provides

@Module
class EmailModule {

    @ApplicationScope
    @Provides
    fun provideEmailService(emailService: EmailServiceImpl): EmailService = emailService

}
