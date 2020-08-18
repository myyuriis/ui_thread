package com.example.ui_thread

import android.os.AsyncTask
import android.widget.ProgressBar
import android.app.ProgressDialog
import org.json.JSONArray
import java.net.HttpURLConnection
import java.net.URL

//class ProgressDialogTask(var progressDialog: ProgressDialog): AsyncTask<String,Int,Unit>(){
//    override fun onPreExecute() {
//        progressDialog.show()
//    }
//
//    override fun doInBackground(vararg params: String?) {
//        for (i in 1..100){
//            Thread.sleep(200)
//            println(i)
//        }
//    }
//
//    override fun onPostExecute(result: Unit?) {
//        progressDialog.dismiss()
//    }
//}
//
//class ProgressThread(var progressBar: ProgressBar): Thread() {
//    override fun run() {
//        for (i in 1..100){
//            progressBar.progress = i
//            println(i)
//            Thread.sleep(200)
//        }
//    }
//}
//
//class ProgressBarTask(var progressBar: ProgressBar): AsyncTask<String, Unit, Unit>(){
//
//    override fun doInBackground(vararg args: String) {
//        for (i in 1..100){
//            progressBar.progress = i
//            println(i)
//            Thread.sleep(200)
//        }
//    }
//}

class FetchDataTask: AsyncTask<String, Unit, Unit>() {
    override fun doInBackground(vararg p0: String?) {
        val url = URL("https://jsonplaceholder.typicode.com/comments?postId=1")
        val urlConnection = url.openConnection() as HttpURLConnection
        urlConnection.requestMethod = "GET"
        val response = urlConnection.inputStream.bufferedReader().readText()
//        println(response)
        
        val jsonArray = JSONArray(response)
        println(jsonArray.getJSONObject(0))
        println(jsonArray.getJSONObject(0).get("email"))
    }
}

