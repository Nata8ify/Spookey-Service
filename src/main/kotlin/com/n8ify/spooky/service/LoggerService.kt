package com.n8ify.spooky.service

import java.lang.Exception
import java.util.*

interface LoggerService {

    fun logAccess(tag: String, ref: String? = null, message: String, inputObject: Any? = null, outputObject: Any? = null, misc : String? = null, level : String)
    fun logSystem(tag: String, ref: String? = null, message: String, inputObject: Any? = null, outputObject: Any? = null, misc : String? = null, level : String)
    fun logError(tag: String, ref: String? = null, message: String, inputObject: Any? = null, outputObject: Any? = null, misc : String? = null, level : String, e : Exception)

}