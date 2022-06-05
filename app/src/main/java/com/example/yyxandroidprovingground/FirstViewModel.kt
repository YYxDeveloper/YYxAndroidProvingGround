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
//    val job1: Job = GlobalScope.launch(Dispatchers.Default) {
//        // launch coroutine in the main thread
//        for (i in 10 downTo 1) { // countdown from 10 to 1
////            textView.text = "count down $i ..." // update text
//            println("yyxxx $i")
//            delay(1000) // wait half a second
//        }
////        textView.text = "Done!"
//        println("yyxxx done")
//    }
    //
    fun practiseCoroutine() = runBlocking {
        val result = withContext(Dispatchers.Default) {
            println("yyxxx job: ${Thread.currentThread().name}")
             "yyxxx2"
        }
        println("yyxxx runBlocking: ${Thread.currentThread().name}")
        println(result)
    }
    fun practiseCoroutine2() {
        println("main start")
        val     job = GlobalScope.launch {
            println("Global Job 1 start")
            delay(2000L)   // suspend for 2 seconds
            println("Global Job 1 stop")
        }
        println("main running")
        runBlocking {
            launch {
                println("Job 2 start")
                delay(500L)   // suspend for  500ms = 0.5 sec
                println("Job 2 stop")
            }
            launch {
                println("Job 3 start")
                delay(1000L) // suspend for 1 sec
                println("Job 3 stop")
            }
            job.join()  // wait job in GlobalScope.launch to finish
        }
        println("main stop")

    }
    suspend fun practiseCoroutine3() {
        val  job = GlobalScope.launch(Dispatchers.Default) {
            // launch coroutine in the main thread
            for (i in 10 downTo 1) { // countdown from 10 to 1
//            textView.text = "count down $i ..." // update text
                println("yyxxx $i")
                delay(1000) // wait half a second
            }
//        textView.text = "Done!"

            println("yyxxx done")
        }
        job.join()
    }
}