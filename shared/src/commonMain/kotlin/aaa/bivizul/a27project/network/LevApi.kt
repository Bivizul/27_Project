package aaa.bivizul.a27project.network

import aaa.bivizul.a27project.model.Leverages
import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.Leveges
import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.Levegesres
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class LevApi {

    val client = HttpClient(CIO) {
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.INFO
        }
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

    suspend fun getLeverages(): Leverages {
        val url = "http://65.109.10.118/27Project/leverages.json"
        val response = client.get(url)
        val body = response.body<Leverages>()
        return body
    }

    suspend fun getLevegesres(leveges: Leveges): Levegesres {
        val url = "http://65.109.10.118/27Project/leveges.php"
        val response = client.post(url) {
            contentType(ContentType.Application.Json)
            setBody(leveges)
        }
        val body = response.body<Levegesres>()
        return body
    }

}