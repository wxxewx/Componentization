package com.example.bus.liveBus


import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import java.lang.NullPointerException
import java.util.HashMap
import kotlin.reflect.KClass


object BusManager {

    private val busEvents: HashMap<String, Bus<*>> = hashMapOf()


    @Synchronized
    fun <T : Any> call(cls: KClass<T>): Bus<T> {
        val key = checkType(cls)

        val bus = busEvents[key]
        if (bus == null) {
            val bus = Bus<T>()
            busEvents[key] = bus
            return bus
        } else {
            return bus as Bus<T>
        }
    }

    @Synchronized
    fun postEvent(event: Any) {
        val key = checkType(event::class)
        val bus = busEvents[key]
        if (bus != null) {
            bus.postEvent(event)
        }
    }


    private fun checkType(cls: KClass<*>): String {
        val event = cls.java.getAnnotation(Event::class.java)
        if (event != null) {
            return (event as Event).key
        } else {
            throw  NullPointerException("not find a class used the Event Annotation")
        }
    }


}


class Bus<T> {
    private var liveData: MutableLiveData<T> = MutableLiveData<T>()

    fun observe(lifecycleOwner: LifecycleOwner, call: (event: T) -> Unit) {
        liveData.observe(lifecycleOwner, Observer { it ->
            it.let {
                call.invoke(it as T)
            }
        })
    }

    fun postEvent(event: Any) {
        liveData.postValue(event as T)
    }
}
