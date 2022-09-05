package aaa.bivizul.a27project.util

import io.ktor.http.*
import kotlinx.serialization.Contextual

expect fun getLevegesmm() : String
expect fun getLevegessim(contextAny:Any) : String
expect fun getLevegesid(contextAny:Any) : String
internal expect fun getLevegesl() : String
expect fun getLevegest() : String
expect fun getLevegedia (contextAny:Any,activityAny:Any)
expect fun checkLevegenet (contextAny:Any) : Boolean

