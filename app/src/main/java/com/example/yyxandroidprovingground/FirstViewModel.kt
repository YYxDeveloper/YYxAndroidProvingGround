package com.example.yyxandroidprovingground

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class FirstViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> get() = _text

    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val job: Job = GlobalScope.launch(Dispatchers.Main) {
        // launch coroutine in the main thread
        for (i in 10 downTo 1) { // countdown from 10 to 1
//            textView.text = "count down $i ..." // update text
            println("yyxxx $i")
            delay(1000) // wait half a second
        }
//        textView.text = "Done!"
        println("yyxxx done")
    }
    //
    fun practiseCoroutine() = runBlocking {
        val result = withContext(Dispatchers.Default) {
            println("yyxxx job: ${Thread.currentThread().name}")
             "yyxxx2"
        }
        println("yyxxx runBlocking: ${Thread.currentThread().name}")
        println(result)
    }
    fun practiseGlobalScope() {


    }
}