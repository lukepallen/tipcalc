package edu.washington.lpa2.tipcalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtTip.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                if (edtTip.text.isNotEmpty()) {
                    var currency = "$" + edtTip.text
                    if (edtTip.text.contains(".")) {
                        val split = edtTip.text.split(".")
                        if (split[1].length > 2) {
                            currency = "$" + split[0] + "." + split[1].substring(0, 2)
                        }
                    }
                    surcharge.text = currency
                    btnTip.setOnClickListener {
                        val tipAmount: String = "$" + (BigDecimal(edtTip.text.toString().toDouble() * 1.15)
                                .setScale(2, BigDecimal.ROUND_HALF_UP)).toString()
                        vwTip.text = tipAmount
                    }
                }
            }

        })
    }

}
