package com.xxx.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // İlk değişkenimizin tanımlamasını yapıyoruz.

    var number1: Int? = null

    // İşleme dahil olacak diğer değişkenimizin tanımlamasını yapıyoruz.

    var number2: Int? = null

    // Hangi işlemi seçtiğimizi gösteren değişkenin tanımlamasını yapıyoruz.

    var operations: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun btn_number_clicked(view: View) {
        val clickedbtn = view as Button;
        //başlangıçtaki değer
        var clickedBtnNumber: String = et_numbers.text.toString()

        when (clickedbtn.id) {

        //hangi butona tıklandıysa o değeri tutuyoruz
            R.id.btn_0 -> {
                clickedBtnNumber += "0"
            }
            R.id.btn_1 -> {
                clickedBtnNumber += "1"
            }
            R.id.btn_2 -> {
                clickedBtnNumber += "2"
            }
            R.id.btn_3 -> {
                clickedBtnNumber += "3"
            }
            R.id.btn_4 -> {
                clickedBtnNumber += "4"
            }
            R.id.btn_5 -> {
                clickedBtnNumber += "5"
            }
            R.id.btn_6 -> {
                clickedBtnNumber += "6"
            }
            R.id.btn_7 -> {
                clickedBtnNumber += "7"
            }
            R.id.btn_8 -> {
                clickedBtnNumber += "8"
            }
            R.id.btn_9 -> {
                clickedBtnNumber += "9"
            }


        }
        //en son hangi numaraya tıklandıysa textView'imize atıyoruz
        et_numbers.setText(clickedBtnNumber)
    }

    fun btn_oparetor_clicked(view: View) {
        val opeatorClick = view as Button

        when (opeatorClick.id) {

        //clear fonksiyonu çağırıp textview'i temizliyor
            R.id.btn_AC -> {
                clear()
            }


            R.id.btn_division -> {
                //ekrandaki değeri number1 e atıyor ve ardından
                //bölme butonu olduğundan hafızaya bölme işaretini atıyor
                //clear ile textview'i temziliyor

                number1 = et_numbers.text.toString().toInt()
                operations = "/"
                clear()

            }

            R.id.btn_value -> {

                //Bu işlemi tanımlamadık
            }

            R.id.btn_extraction -> {
                number1 = et_numbers.text.toString().toInt()

                operations = "-"
                clear()
            }

            R.id.btn_sum -> {
                number1 = et_numbers.text.toString().toInt()
                operations = "+"
                clear()
            }

            R.id.btn_multiplication -> {

                number1 = et_numbers.text.toString().toInt()
                operations = "*"
                clear()

            }
            R.id.btn_eqauls -> {

                //eğer direk bir sayı girilmeden veya  işlem seçmeden yapılırsa hata döndürüyoruz
                if (number1 == null) Toast.makeText(this, "Hata işlemi seçiniz", Toast.LENGTH_SHORT)
                else {
                    //ilk sayıyı girip sonra  işlemi seçip = buttonuna basıldığında
                    //number2 içerisinde = bastığındaki sayıyı hafızada tutuyor
                    number2 = et_numbers.text.toString().toInt()

                    when (operations) {
                    //gelen  işleme göre yapıp krana basıyor
                        "/" -> {
                            et_numbers.setText("${number1!! / number2!!}")
                        }
                        "*" -> {
                            et_numbers.setText("${number1!! * number2!!}")
                        }
                        "+" -> {
                            et_numbers.setText("${number1!! + number2!!}")
                        }
                        "-" -> {
                            et_numbers.setText("${number1!! - number2!!}")
                        }
                    }

                }

            }


        }
    }


    private fun clear() {
        et_numbers.setText("")
    }


}
