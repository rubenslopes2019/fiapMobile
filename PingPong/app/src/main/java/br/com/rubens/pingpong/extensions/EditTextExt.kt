package br.com.rubens.pingpong.extensions

import android.widget.EditText

fun EditText.value() = this.text.toString()