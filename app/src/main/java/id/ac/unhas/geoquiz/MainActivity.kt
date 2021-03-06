package id.ac.unhas.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var nextButton: Button
    private lateinit var previousButton: Button
    private lateinit var questionTextView: TextView
    private lateinit var trueButton:Button
    private lateinit var falseButton:Button

    private val TAG = "Main Activity";


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG,"onCreate(Bundle?)called")


        //declare btn and textview
        nextButton = findViewById(R.id.next_btn)
//        previousButton = findViewById(R.id.previous_btn)
        questionTextView = findViewById(R.id.question_text_view)
        trueButton = findViewById(R.id.true_btn)
        falseButton = findViewById(R.id.false_btn)


        //tempat eksekusi atau mau diapakan ki wkwkwwk

        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)


        nextButton.setOnClickListener {
            currentIndex = (currentIndex+1)%questionBank.size
            val questionTextResId = questionBank[currentIndex].textResId
            questionTextView.setText(questionTextResId)

        }

//        previousButton.setOnClickListener{
//            currentIndex = (currentIndex-1)%questionBank.size
//            if (currentIndex < 0){
//                Toast.makeText(this,R.string.gk_ada_prev,Toast.LENGTH_SHORT).show()
//                currentIndex = 0
//            }else {
//                val questionTextResId = questionBank[currentIndex].textResId
//                questionTextView.setText(questionTextResId)
//            }
//        }


        trueButton.setOnClickListener {
            checkAnswer(true)
        }

        falseButton.setOnClickListener {
            checkAnswer(false)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }


    //ALL ABOUT FUNCTION AND OBJECT

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )
    private var currentIndex = 0

    private fun checkAnswer(userAnswer:Boolean){
        val correctAnswer = questionBank[currentIndex].answer
        val messageId = if (userAnswer==correctAnswer){
            R.string.correct_toast
        }else{
            R.string.wrong_toast
        }
        val toast = Toast.makeText(this,messageId,Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.TOP or Gravity.CENTER_VERTICAL,0,0)
        toast.show()
    }
}


