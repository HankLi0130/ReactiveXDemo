package app.hankdev.reactivexandroiddemo

import android.util.Log
import io.reactivex.rxjava3.core.Observable

object Api {

    const val TAG = "Api"

    fun call(username: String, password: String): Observable<String> {
        // 模擬 call api
        return Observable.create { emitter ->
            if (username == "abc" && password == "0000") {
                emitter.onNext("OK")
                emitter.onComplete()
            } else {
                emitter.onError(Throwable("Wrong username or password!"))
            }

            Log.i(TAG, "call: current thread: ${Thread.currentThread().name}")
        }
    }
}