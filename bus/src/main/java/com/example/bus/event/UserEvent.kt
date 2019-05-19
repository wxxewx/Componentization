package com.example.bus.event

import android.support.annotation.CheckResult
import com.example.bus.liveBus.Event

@Event("UserEvent")
class UserEvent(var newName: String)