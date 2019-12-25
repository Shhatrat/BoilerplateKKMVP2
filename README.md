# BoilerplateKKMVP

Welcome to my boilerplate Android project. Firstly, why I named it KKMVP?

<b>K</b>otlin

<b>K</b>oin

<b>M</b>odel<b>V</b>iew<b>P</b>resenter

# Technologies and patterns used
- MVP with contracts
- 100% Kotlin
- AndroidX
- Retrofit2 and OkHttp
- RxJava2
- Koin (DI)
- Room
- Latest sdk

# MVP with contracts
This pattern allow us to easy hermetization beetween Views and Presenters.
```
interface IJokeContract{
    interface V: IView{
        fun showJokeText(joke: String)
        ...
        fun onShowNewJoke(action: () -> Unit)
    }
    interface P: IPresenter<V>
}
```
Interface `V` should be implement by inheritance `BaseActivity` or `BaseFragment` class. This solution automatically attach and detach presenter object in proper moment of `Activity` of `Fragment` lifecycle.

Interface `P` should be implement by inheritance `BasePresenter` class. `BasePresenter` contains `subscriptions` variable (`CompositeDisposable`), every RxJava's Disposable should be add to it (preventing memory leaks).

Every `P's` interface should be bind to implmentation by factory in `PresenterModule` file.
```
...
    factory<IJokeContract.P> { JokePresenterImpl(get(), get()) }
...
```
You you shouldn't add any code to `*Contract.P` file. View class shouldn't know anything about Presenter. Better way is setting listeners like this: 
```
    override fun onShowNewJoke(action: () -> Unit) {
        getNewJokeBtn.setOnClickListener { action.invoke() }
    }
```

See `com.shhatrat.boilerplate_kkmvp.ui.joke` for more details and example.

# How-to
- clone this repository
- in `app/build.gradle` change `applicationId` to your package
- in `strings.xml` change `app_name`
- change `Boilerplate.kt`class name to other
- change `com.shhatrat.boilerplatekkmvp` package to your package
- remove `.git` files and directories
