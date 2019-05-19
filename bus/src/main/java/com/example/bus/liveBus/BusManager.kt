package com.example.bus.liveBus


import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import java.lang.NullPointerException
import java.util.HashMap


object BusManager {

    private val busEvents: HashMap<String, Bus<Any>>
        get() = hashMapOf()


    @Synchronized
    fun <T : Any> observe(lifecycleOwner: LifecycleOwner, cls: Class<Any>): Bus<Any>? {
        val key = checkType(cls)

        val bus = busEvents[key]
        if (bus == null) {
            val mutableLiveData = MutableLiveData<T>()
            val bus = Bus<T>(lifecycleOwner, mutableLiveData) as Bus<Any>
            busEvents[key] = bus
            return bus
        } else {
            return bus
        }
    }

    @Synchronized
    fun postEvent(event: Event) {
        val key = checkType(event.javaClass)
        val bus = busEvents[key]
        if (bus != null) {
            bus.postEvent(event)
        }
    }


    private fun checkType(cls: Class<Any>): String {
        val annotations = cls.annotations
        val event = annotations.find {
            it is Event
        }
        if (event != null) {
            return (event as Event).key
        } else {
            throw  NullPointerException("not find a class used the Event Annotation")
        }
    }


}


class Bus<T>(var lifecycleOwner: LifecycleOwner, var liveData: MutableLiveData<T>) {


    fun call(call: (event: T) -> Unit) {
        liveData.observe(lifecycleOwner, Observer { it ->
            it.let {
                call.invoke(it as T)
            }
        })
    }

    fun postEvent(event: T) {
        liveData.postValue(event)
    }
}
