package com.homework.fbmxdg.subnavigation

import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

class LocalCiceroneHolder {

    private val containers: HashMap<String, Cicerone<Router>> = HashMap()

    fun getCicerone(containerTag: String): Cicerone<Router> = containers.getOrPut(containerTag) { Cicerone.create() }
}

