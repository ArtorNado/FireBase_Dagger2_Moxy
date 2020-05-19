package com.homework.fbmxdg.service.di

import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.homework.fbmxdg.app.scope.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class FirebaseModule {

    @ApplicationScope
    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @ApplicationScope
    @Provides
    fun provideFireBaseDataBase(): FirebaseFirestore = Firebase.firestore

    @ApplicationScope
    @Provides
    fun provideFireBaseLogs(): FirebaseAnalytics = Firebase.analytics

    @ApplicationScope
    @Provides
    fun provideFireBaseRemoteConfig(): FirebaseRemoteConfig = Firebase.remoteConfig

}
