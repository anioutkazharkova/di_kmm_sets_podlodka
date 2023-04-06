### Setup gradle
```
implementation("org.kodein.di:kodein-di:7.19.1")
```


### Setup DI
```
class KodeinDI {

    val serviceModule = org.kodein.di.DI.Module("service") {
        bindSingleton{
            NetworkClient()
        }
        bindSingleton {
            NewsService(instance())
        }
    }

    val viewModels = org.kodein.di.DI.Module("viewModels") {
        bindProvider {
            NewsViewModel(instance())
        }
    }
    val useCases = org.kodein.di.DI.Module("usecases") {
        bindProvider {
           NewsUseCase(instance())
        }
    }

    val di = org.kodein.di.DI {
        import(serviceModule)
        import(useCases)
        import(viewModels)
    }
}
```

### Dummy access 
```
object DIFactory  {
     val di: DI by lazy {
        KodeinDI().di
    }
   val viewModel:NewsViewModel by di.instance()
}
```

### Factory 2
```
object DIFactory {
     val di: DI by lazy {
        KodeinDI().di
    }
    inline fun <reified T> resolve(): LazyDelegate<T> {
        return di.instance()
    }
}

```

### Factory 1
```
object DIFactory  {
     val di: DI by lazy {
        KodeinDI().di
    }

    val diDirect = di.direct

    inline fun <reified T> resolve(): LazyDelegate<T> {
        return di.instance()
    }

    inline fun<reified  T> resolveDirect():T? {
        return diDirect.instance()
    }
}

```


### VMFactory
```
object VMFactory {
    fun createVM(type: BaseView):ViewModel? {
       return when(type) {
            is NewsView -> DIFactory.diDirect.instance<NewsViewModel>()
           else -> null
       }
        return null
    }

//DUMMY !!! Not working with iOS
    inline fun<reified T:ViewModel> getVM():T? {
        return DIFactory.diDirect.instance() as? T
    }
}

```