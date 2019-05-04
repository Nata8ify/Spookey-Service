package com.n8ify.spooky.controller

import com.n8ify.spooky.constant.Log
import com.n8ify.spooky.model.common.VersionInfo
import com.n8ify.spooky.service.LoggerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import java.util.*

@Controller
class CommonController {

    val TAG = CommonController::class.java.simpleName

    @Value(value = "\${build.name}") lateinit var  name : String
    @Value(value = "\${build.versionCode}") lateinit var  versionCode : String
    @Value(value = "\${build.version}") lateinit var  version : String
    @Value(value = "\${build.timestamp}") lateinit var  timestamp : String
    @Value(value = "\${build.environment}") lateinit var environment : String

    @Autowired lateinit var loggerService : LoggerService

    @GetMapping(path = ["/version"])
    @ResponseBody
    fun version(): VersionInfo {
        val version : VersionInfo = VersionInfo(name, versionCode, version, timestamp, environment)
        loggerService.logAccess(tag = TAG, message = "View for Application Version", outputObject = version,level = Log.LEVEL_INFO)
        return version
    }
}

