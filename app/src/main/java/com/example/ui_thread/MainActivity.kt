package com.example.ui_thread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val maxProgress: Int = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressBar.max = maxProgress
        start_progress_button.setOnClickListener(this)
//        progressDialog = ProgressDialog(this)
//        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER)
    }

    override fun onClick(v: View?) {
        when (v) {
            start_progress_button -> startProgress()
        }
    }

    fun startProgress() {
        //ProgressTread
//        var progressThread = ProgressThread(progressBar)
//        progressThread.start()
//        ProgressThread(this).execute()

        //ProgressTask
//        var progressBarTask = ProgressBarTask(progressBar)
//        progressBarTask.execute()

        //ProgressDialog
//        val progressDialogTask = ProgressDialogTask(progressDialog)
//        progressDialogTask.execute()

        //Coroutine
        CoroutineScope(Dispatchers.IO).launch {
            for (i in 1..100) {
                progressBar.setProgress(i)
                delay(50)
            }
        }
    }
}

//    class ProgressDialogTask(var progressDialog: ProgressDialog): AsyncTask<String,Int,Unit>(){
//        override fun onPreExecute() {
//            progressDialog.show()
//        }
//
//        override fun doInBackground(vararg params: String?) {
//            for (i in 1..100){
//                Thread.sleep(200)
//                println(i)
//            }
//        }
//
//        override fun onPostExecute(result: Unit?) {
//            progressDialog.dismiss()
//        }
//    }

//class ProgressThread(var progressBar: ProgressBar): Thread() {
//    override fun run() {
//        for (i in 1..100){
//            progressBar.progress = i
//            println(i)
//            Thread.sleep(200)
//        }
//    }
//}

//class ProgressBarTask(var progressBar: ProgressBar): AsyncTask<String,Unit,Unit>(){
//
//    override fun doInBackground(vararg args: String) {
//        for (i in 1..100){
//            progressBar.progress = i
//            println(i)
//            Thread.sleep(200)
//        }
//    }
//}