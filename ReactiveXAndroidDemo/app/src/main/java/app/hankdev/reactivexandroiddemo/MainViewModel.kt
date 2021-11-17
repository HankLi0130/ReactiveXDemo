package app.hankdev.reactivexandroiddemo

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel: ViewModel() {

    fun login(username: String, password: String): Observable<String> {
        // 模擬 call api
        return Api.call(username, password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}