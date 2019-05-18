package com.example.bus.liveBus


import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import java.util.HashMap


object BusManager {

    private val busEvents: HashMap<String, Bus<IEvent>>
        get() = hashMapOf()


    fun <T : IEvent> observe(lifecycleOwner: LifecycleOwner, event: IEvent): Bus<IEvent>? {
        val bus = busEvents[event.key]
        if (bus == null) {
            val mutableLiveData = MutableLiveData<IEvent>()
            val bus = Bus<T>(lifecycleOwner, mutableLiveData) as Bus<IEvent>
            busEvents[event.key] = bus
            return bus
        } else {
            return bus
        }
    }


}


class Bus<T : IEvent>(var lifecycleOwner: LifecycleOwner, var liveData: MutableLiveData<IEvent>) {


    fun observe(call: (event: T) -> Unit) {
        liveData.observe(lifecycleOwner, Observer {
            call.invoke(it as T)
        })
    }
}
