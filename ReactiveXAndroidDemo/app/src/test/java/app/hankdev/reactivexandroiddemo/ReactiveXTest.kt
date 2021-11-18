package app.hankdev.reactivexandroiddemo

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.Test

class ReactiveXTest {

    @Test
    fun stream() {
        val list = listOf(1, 2, 3, 4, 5, 6)
            .map { it * 10 }

        println(list)
    }

    @Test
    fun firstRxFlow() {
        println("--------------------------------------------")

        Observable.just("Hello Rx")
            .map { item -> item + "!!!" }
            .subscribe(object : Observer<String> {
                override fun onSubscribe(d: Disposable) {
                    println("onSubscribe")
                }

                override fun onNext(t: String) {
                    println("onNext: $t")
                }

                override fun onError(e: Throwable) {
                    println("onError: ${e.message}")
                }

                override fun onComplete() {
                    println("onComplete")
                }

            })


        println("--------------------------------------------")
    }

    @Test
    fun rxFlowDemo1() {
        println("--------------------------------------------")

        val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        Observable.fromIterable(list)
            .map { num -> num * 10 }
            .filter { num -> num < 50 }
            .subscribe({ num ->
                println("onNext: $num")
            }, { e ->
                println("onError: ${e.message}")
            }, {
                println("onComplete")
            })

        println("--------------------------------------------")
    }

    @Test
    fun rxFlowDemo2() {
        println("--------------------------------------------")

        callApi().subscribe({ str ->
            println("onNext: $str")
            //println("Thread: ${Thread.currentThread()}")
        }, { e ->
            println("onError: ${e.message}")
        }, {
            println("onComplete")
        })

        println("--------------------------------------------")
    }

    private fun callApi(): Observable<String> {
        return Observable.just("result")
        //.observeOn(Schedulers.io())
    }
}