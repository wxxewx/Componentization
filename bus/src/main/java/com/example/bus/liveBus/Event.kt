package com.example.bus.liveBus

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.SOURCE)
annotation class Event (val key: String)