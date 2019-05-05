package com.n8ify.spooky.service.impl

import com.n8ify.spooky.constant.Log
import com.n8ify.spooky.service.LoggerService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class LoggerServiceImpl : LoggerService {

    val accessLogger = LoggerFactory.getLogger(Log.TITLE_ACCESS_LOG)
    val systemLogger = LoggerFactory.getLogger(Log.TITLE_SYSTEM_LOG)
    val errorLogger = LoggerFactory.getLogger(Log.TITLE_ERROR_LOG)

    override fun logAccess(tag: String, ref: String?, message: String, inputObject: Any?, outputObject: Any?, misc : String?, level : String) {
        val logBody = "[$tag]-[$ref] :: ($message) : [Input = $inputObject, Output = $outputObject] : ($misc)"
        logBody.let {
            when(level){
                Log.LEVEL_DEBUG -> accessLogger.debug(it)
                Log.LEVEL_INFO -> accessLogger.info(it)
                Log.LEVEL_WARING -> accessLogger.warn(it)
                else -> accessLogger.trace(it)
            }
        }
    }

    override fun logSystem(tag: String, ref: String?, message: String, inputObject: Any?, outputObject: Any?, misc: String?, level: String) {
        val logBody = "[$tag]-[$ref] :: ($message) : [Input = $inputObject, Output = $outputObject] : ($misc)"
        logBody.let {
            when(level){
                Log.LEVEL_DEBUG -> systemLogger.debug(it)
                Log.LEVEL_INFO -> systemLogger.info(it)
                Log.LEVEL_WARING -> systemLogger.warn(it)
                else -> systemLogger.trace(it)
            }
        }}

    override fun logError(tag: String, ref: String?, message: String, inputObject: Any?, outputObject: Any?, misc: String?, level: String, e: Exception) {
        val logBody = "[$tag]-[$ref] :: ($message) : [Input = $inputObject, Output = $outputObject] : ($misc)"
        errorLogger.error(logBody)
        e.printStackTrace()
    }


}