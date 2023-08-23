package com.example.practice.service.server

import com.google.gson.Gson
import retrofit2.Response
import java.net.SocketTimeoutException
import java.net.UnknownHostException

abstract class BaseRepository {

    suspend fun <T: Any> safeApiCall(call: suspend () -> Response<T>): Response<T>? {
        return try {
            return call.invoke()
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            null
        } catch (e: SocketTimeoutException) {
            e.printStackTrace()
            null
        } catch (e: UnknownHostException) {
            e.printStackTrace()
            null
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

}