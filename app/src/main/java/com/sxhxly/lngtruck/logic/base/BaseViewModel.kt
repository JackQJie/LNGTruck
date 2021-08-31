package com.sxhxly.lngtruck.logic.base

import androidx.annotation.Nullable
import androidx.lifecycle.*
import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


open class BaseViewModel() : ViewModel(), LifecycleEventObserver {

    val tokenExpir: MutableLiveData<Boolean> = MutableLiveData()
    val error: MutableLiveData<Boolean> = MutableLiveData()

    var compositeDisposable = CompositeDisposable()

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_DESTROY -> {
                (compositeDisposable.dispose())
            }
            Lifecycle.Event.ON_CREATE -> TODO()
            Lifecycle.Event.ON_START -> TODO()
            Lifecycle.Event.ON_RESUME -> TODO()
            Lifecycle.Event.ON_PAUSE -> TODO()
            Lifecycle.Event.ON_STOP -> TODO()
            Lifecycle.Event.ON_ANY -> TODO()
        }
    }

    protected abstract class SimpleObserver<T> : Observer<T> {

        override fun onSubscribe(d: Disposable) {
            TODO("Not yet implemented")
        }

        override fun onNext(t: T) {
            TODO("Not yet implemented")
        }

        override fun onError(e: Throwable) {
            TODO("Not yet implemented")
        }

        abstract fun onSuccess(@Nullable t : T)

        override fun onComplete() {
            TODO("Not yet implemented")
        }
    }

}